package com.test.queryPasing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class XmlAddComment {

	public static void main(String[] args) throws Exception {
		// File file = new File("D:\\gdsMgmtMapper.xml");
	
		File file = new File("D:/class/MDL/MLIF/webapp/WEB-INF/sqlmap/mariadb/mlif/trnsmit/trnsmitMapper.xml");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		String line = "";
		File fileOut = new File("d:/test/", "test1.xml");
		FileOutputStream os = new FileOutputStream(fileOut);
		System.out.println("시작");
		/**
		 * 새로운 시도 select를 한 줄롱 읽어서 처리하자
		 */
		List<String> arr = new ArrayList<>();
		StringBuilder mb = new StringBuilder();
		StringBuffer sb = new StringBuffer();
		String id = "";
		while ((line = reader.readLine()) != null) {
			mb.append(line);
			String l = line.toLowerCase().trim();
			String namespace = "";
			String[] cruds = new String[]{"select","update","insert","delete"};
			if (l.startsWith("<mapper")) {
				namespace = cutter(l, "\"", "\"");
				while ((line = reader.readLine()) != null) {
					// sb.append(line);
					String tab = line.substring(0, line.indexOf("<") <=0?0 : line.indexOf("<"));
					l = line.toLowerCase().replaceAll("\\s", "");
					for (String crud : cruds) {
						if(l.startsWith(String.format("<%s",crud))){
							id = cutter(l.substring(l.indexOf("id=")), "\"", "\"");
							if (l.endsWith(String.format("</%s>", crud))) { // xml이 한줄로 작성되어있는 경우
								line = insertInlineComment(line,namespace,id);
							}else{
								line = concat(line, System.lineSeparator(),tab,insertInlineComment("",namespace,id));
							}
							break;
						}
					}
					mb.append(line);
					mb.append(System.lineSeparator());
				}

			}
		}
		System.out.println(mb.toString());
		os.write(mb.toString().getBytes());
		os.close();
		// secondShot(list, stack, now, arr, skip);
		// fuckedup(reader, list, stack, now);
		reader.close();
		System.out.println("끝");
	}

	public static String cutter(String line, String start, String end) {
		int s = line.indexOf(start) + 1;
		int e = line.indexOf(end, s + 1) - 1;
		return line.substring(s, e + 1);
	}
	public static String insertInlineComment(String line, String namespace, String id){
		StringBuilder sb=  new StringBuilder();
		int idx = line.indexOf(">");
		int len = line.length() <= 0 ? 1:line.length();
		sb.append(line, 0, idx+1);
		sb.append(String.format("/** %s.%s */", namespace,id));
		sb.append(line, idx+1, len-1);
		return sb.toString();
	}
	public static String concat(String ori,String... adds){
		StringBuilder sb = new StringBuilder(ori);
		for (String string : adds) {
			sb.append(string);
		}
		return sb.toString();
	}

}
