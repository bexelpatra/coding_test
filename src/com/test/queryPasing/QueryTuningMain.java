package com.test.queryPasing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class QueryTuningMain {

	public static void main(String[] args) throws Exception {
		// File file = new File("D:\\gdsMgmtMapper.xml");
		// File file = new
		// File("D:/class/MDL/MLIF/webapp/WEB-INF/sqlmap/mariadb/mlif/trnsmit/trnsmitMapper.xml");
		File file = new File("D:/test/trnsmitMapper.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = "";
		List<Table> list = new ArrayList<>();
		Stack<Table> stack = new Stack<>();
		Table now = null;
		System.out.println("시작");
		/**
		 * 새로운 시도 select를 한 줄롱 읽어서 처리하자
		 */
		List<String> arr = new ArrayList<>();
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			StringBuffer sb = new StringBuffer();
			if (line.toLowerCase().startsWith("<select")) {
				String innerLine = "";
				while ((innerLine = reader.readLine()) != null) {

					innerLine = innerLine.trim().toLowerCase() + " ";
					if (innerLine.indexOf("--") != -1) {
						innerLine = innerLine.substring(0, innerLine.indexOf("--"));
					}
					if (innerLine.startsWith("</select")) { // select문만 건져내기
						String temp = sb.toString();
						System.out.println(temp);
						System.out.println(temp.indexOf("<!--"));
						temp = TuningUtils.removeData(temp, "<!--", "-->", false);
						System.out.println(temp);
						arr.add(temp);
						break;
					}
					// sb.append(temp.replace(System.lineSeparator(), " "));
					// temp = temp.replaceAll("\b", "");
					// innerLine = TuningUtils.removeData(innerLine, "<![cdata[", "]]>", true);
					// innerLine = TuningUtils.removeData(innerLine, "<!--", "-->", false);
					// innerLine = TuningUtils.removeData(innerLine, "/*", "*/", false);
					// System.out.println(innerLine);
					sb.append(innerLine);
				}

			}
		}

		for (String string : arr) {
			// System.out.println(string);
		}

		// secondShot(list, stack, now, arr, skip);
		// fuckedup(reader, list, stack, now);
		System.out.println("끝");
	}

	// 조건절 분기
	private static void secondShot(List<Table> list, Stack<Table> stack, Table now, List<String> arr, boolean skip) {
		for (String query : arr) {
			// System.out.println(query);
			String[] words = query.split(" ");
			for (int i = 0; i < words.length; i++) {
				String word = words[i].trim();
				if (word.equals("<!--")) {
					skip = true;
				} else if (word.equals("-->")) {
					skip = false;
				}
				if (skip)
					continue;
				System.out.printf("%s\n", word);
				// word.
				if (word.equals("from")) { // 테이블 생성하고 where 절을 찾는다. 이때 join을 신경써서 찾아야 한다
					if (words[i + 1].startsWith("(")) {
						now = new Table(words[i + 1]);
					}
				} else if (word.startsWith("(select") || word.equals("select")) { // 서브쿼리
					// System.out.println();
					if (now != null) {
						stack.add(now);
						now = null;
					}
					// 여기서 열린거 확인한 다음 닫히는 부분 어딘지 찾아내야 한다.
				} else if (word.equals("where")) { // 그만 두는 조건이 나올때까지 조건들을 채굴해내야 한다.
					// System.out.println();
				}
			}
			list.add(now);
			System.out.println();
		}
	}

	/**
	 * readLine으로 하니까 헷갈려서 못하겠음
	 * 
	 * @param reader
	 * @param list
	 * @param stack
	 * @param now
	 * @throws IOException
	 */
	private static void fuckedup(BufferedReader reader, List<Table> list, Stack<Table> stack, Table now)
			throws IOException {
		String line;
		while ((line = reader.readLine()) != null) {
			line = line.trim();
			String[] words = line.split(" ");
			for (int i = 0; i < words.length; i++) {
				String word = words[i];
				if (word.toLowerCase().equals("from")) {
					if (now != null) {
						stack.add(now);
					}
					now = new Table(words[i + 1]); // 다음 번에 where이 아니면 alias, 아마도 join이 나올 가능성이 매우 높다.

					if (word.toLowerCase().equals("where")) {
						char c = '0';
						while ((c = (char) reader.read()) != -1) {
							if (c == ')') {
								// from 닫힌거지
								list.add(now);
								break;
							} else if (c == '<') {
								char[] seq = new char[6];
								reader.read(seq);
								String check = new String(seq).toLowerCase();
								if ("/select".equalsIgnoreCase(check)) {
									list.add(now);
									break;
								} // 닫힌거지
							}
						}
					}

				}
			}
		} // while
	}

}
