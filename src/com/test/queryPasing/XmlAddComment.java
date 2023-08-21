package com.test.queryPasing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// xml에 query id 추가하기
// 메타쿼리와 내용 사이에 id를 추가
// 기존에 주석이 있으면 내버려 둔다...
public class XmlAddComment {

	public static void main(String[] args) throws Exception {
		System.out.println("시작");
		String fileName1 = "D:/class/MDL/MLIF/webapp/WEB-INF/sqlmap";
		String fileName2 = "D:/class/MDL_ADMIN/MLIF/webapp/WEB-INF/sqlmap/";
		String fileName3 = "d:/test/";

		File mlifAdmin = new File(fileName3);
		// test(mlif);
		// if (true) {
		// return;
		// }
		recursiveFile(mlifAdmin, "\t");

		// File file = new
		// File("D:/class/MDL/MLIF/webapp/WEB-INF/sqlmap/mariadb/mlif/trnsmit/trnsmitMapper.xml");
		// addQueryId(file);
		System.out.println("끝");
	}

	private static void test(File file) {
		for (File cFile : file.listFiles()) {
			if (cFile.isDirectory()) {
				test(cFile);
			} else if (cFile.isFile()) {
				// System.out.println(cFile.getName());
				int start = 0;
				for (int i = 0; i < 8; i++) {
					start = cFile.getAbsolutePath().indexOf("\\", start + 1);
				}
				System.out.println(cFile.getAbsolutePath().substring(start));
				System.out.println(new File("d:/test/" + cFile.getAbsolutePath().substring(start)).getAbsolutePath());
			}
		}

	}

	/**
	 * 
	 * @param file  복사 대상이 되는 파일
	 * @param level 앞에서 부터 몇번째 폴더까지 끊을지 결정한다.
	 * @return
	 */
	private static String getFileName(File file, int level) {
		int start = -1;
		int max = 0;
		while ((start = file.getAbsolutePath().indexOf("\\", start + 1)) != -1) {
			max += 1;
		}
		start = -1;
		if (max < level) {
			level = max - 1;
		}
		for (int i = 0; i < level; i++) {
			start = file.getAbsolutePath().indexOf("\\", start + 1);
		}
		return file.getAbsolutePath().substring(start);
	}

	/**
	 * 
	 * @param dir 탐색을 시작할 root
	 * @param tab 파일 구조를 확인 띄어쓰기 용
	 * @throws Exception
	 */
	private static void recursiveFile(File dir, String tab) throws Exception {
		for (File file : dir.listFiles()) {
			// System.out.println(tab + file.getName());
			if (file.isDirectory()) {
				recursiveFile(file, String.format("%s%s", tab, tab));
			} else if (file.isFile() && file.getName().toLowerCase().endsWith(".xml")) {
				addQueryId(file);
			}
		}
	}

	/**
	 * 
	 * @param file 복사 대상이 되는 파일
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	private static void addQueryId(File file) throws FileNotFoundException, IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = "";
		String name = getFileName(file, 7);
		File fileOut = new File("d:/test/test2", name);
		if (!fileOut.getParentFile().exists()) {
			fileOut.getParentFile().mkdirs();
		}
		// File fileOut = new File("d:/test/",getFileName(file, 7));
		FileOutputStream os = new FileOutputStream(fileOut);

		/**
		 * 새로운 시도 select를 한 줄씩 읽어서 처리하자
		 */
		List<String> arr = new ArrayList<>();
		StringBuilder mb = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		String id = "";
		while ((line = reader.readLine()) != null) {
			mb.append(line);
			mb.append(System.lineSeparator());
			String l = line.toLowerCase().trim();
			String namespace = "";
			String[] cruds = new String[] { "select", "update", "insert", "delete" };
			if (l.startsWith("<mapper")) { // namespace 획득
				namespace = cutter(l, "\"", "\"");
				while ((line = reader.readLine()) != null) {
					String tab = line.substring(0, line.indexOf("<") <= 0 ? 0 : line.indexOf("<")); // 현재 tab 획득
					l = line.toLowerCase().replaceAll("\\s", ""); // 모든 공백을 제거한 수정용 줄
					for (String crud : cruds) {
						if (l.startsWith(String.format("<%s", crud))) {
							int idIdx = l.indexOf("id=");
							if (idIdx == -1) {
								break;
							}
							id = cutter(l.substring(idIdx), "\"", "\""); // query id 획득
							if (l.endsWith(String.format("</%s>", crud))) { // xml이 한줄로 작성되어있는 경우
								line = insertInlineComment(line, namespace, id);
							} else {
								line = concat(line, System.lineSeparator(), tab,
										insertInlineComment("", namespace, id));
							}
							break;
						}
					}
					mb.append(line);
					mb.append(System.lineSeparator());
				}

			}
		}

		// System.out.println(mb.toString());
		os.write(mb.toString().getBytes());
		os.close();

		reader.close();
		// System.out.println(String.format("@@@ %s finished...\n",
		// file.getAbsolutePath()));
	}

	public static String cutter(String line, String start, String end) {
		return cutter(line, start, end, 0);
	}

	public static String cutter(String line, String start, String end, int from) {
		int s = line.indexOf(start, from) + 1;
		int e = line.indexOf(end, s + 1) - 1;
		return line.substring(s, e + 1);
	}

	public static String insertInlineComment(String line, String namespace, String id) {
		StringBuilder sb = new StringBuilder();
		int idx = line.indexOf(">");
		int len = line.length() <= 0 ? 1 : line.length();
		sb.append(line, 0, idx + 1);
		sb.append(String.format("/** %s.%s */", namespace, id));
		sb.append(line, idx + 1, len - 1);
		// if (line.substring(idx + 1, len - 1).replaceAll("\\s", "").length() > 0) {
		// sb.append(System.lineSeparator());
		// }
		return sb.toString();
	}

	public static String concat(String ori, String... adds) {
		StringBuilder sb = new StringBuilder(ori);
		for (String string : adds) {
			sb.append(string);
		}
		return sb.toString();
	}

}
