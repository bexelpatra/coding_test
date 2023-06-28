package com.test;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.output.FileWriterWithEncoding;

public class FileContentUpdate {

	public static void main(String[] args) throws Exception {
		// extracted();
		// cleanPropertoes(new String[] { "userid", "password" });
		// extracted2();
		propertiesLoad();
		System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
		String[] reset = propertiesMap.get("reset").split("[^a-zA-Z0-9]");

		for (String string : reset) {
			System.out.println(string);
		}
		System.out.println("".equals(reset[reset.length - 1]));

	}

	private static Map<Object, String> propertiesMap;

	private static void propertiesLoad() throws IOException, FileNotFoundException, UnsupportedEncodingException {
		Properties properties = new Properties();
		properties.load(new BufferedInputStream(new FileInputStream(new File("d:/t/dot.properties"))));

		if (propertiesMap == null) {
			propertiesMap = new HashMap<>();
		}
		System.out.println();
		System.out.println("\t\tchecking your properties file\n");
		for (Object ob : properties.keySet()) {
			System.out.println(String.format("\t\t %-15s : \t %s", ob.toString(),
					new String(properties.getProperty(ob.toString()).getBytes("ISO-8859-1"), "utf-8")));
			propertiesMap.put((String) ob,
					new String(properties.getProperty(ob.toString()).getBytes("ISO-8859-1"), "utf-8"));
		}
	}

	private static void filePathTest() {
		File temp = new File("src/temp.txt");
		if (!temp.exists()) {
			temp.mkdirs();
		}
		System.out.println(temp.getAbsolutePath());
		System.out.println(temp.getParentFile());
		temp.delete();
	}

	private static void extracted() {
		try {
			String path = "D:/t/";
			String name = "1my.txt";
			File src = new File(path + name);
			File dst = new File(path + "2my.txt");

			BufferedReader reader = new BufferedReader(new FileReader(src));
			BufferedWriter writer = new BufferedWriter(new FileWriter(dst));
			String line = null;
			char s = 'a';
			while ((line = reader.readLine()) != null) {
				if (line.charAt(0) == 'c') {
					writer.write("raise your glass" + "\n");
					continue;
				}
				System.out.println(line);
				writer.write(s++ + "=");
				writer.write((int) (Math.random() * 10000) + "\n");
			}
			writer.flush();
			reader.close();
			writer.close();
			;
			File temp = new File("temp");
			src.renameTo(temp);
			System.out.println(dst.renameTo(src));
			temp.deleteOnExit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String[] list = new String[] { "1", "2" };
		String t = "userid=u00242";
		System.out.println(t.substring(0, t.indexOf("=") + 1));
	}

	public static void cleanPropertoes(String[] keys) throws Exception {
		try {
			// String path = "src/";
			String path = "D:/t/";
			String name = "dot.properties";
			File src = new File(path + name);
			File dst = new File(path + "temp.properties");

			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(src), "ISO-8859-1"));
			BufferedWriter writer = new BufferedWriter(new FileWriterWithEncoding(dst, "ISO-8859-1"));
			String line = null;
			while ((line = reader.readLine()) != null) {
				System.out.println(new String(line.getBytes("ISO-8859-1"), "UTF-8"));
				// 키값 확인
				String key = line.split("=")[0];
				// 쓰기 시작
				if (contain(keys, key)) {
					writer.write(key + "=");
				} else {
					writer.write(line);
				}
				writer.write(System.lineSeparator());
			}
			writer.flush();
			reader.close();
			writer.close();

			// 파일 이름 변경하기
			File temp = new File("temp");
			src.renameTo(temp);
			System.out.println(dst.renameTo(src));
			temp.deleteOnExit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	private static boolean contain(String[] list, String src) {
		for (String a : list) {
			if (a.equals(src)) {
				return true;
			}
		}
		return false;
	}
}
