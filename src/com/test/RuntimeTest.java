package com.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class RuntimeTest {

	public static void main(String[] args) {
		Runtime rt = Runtime.getRuntime();
		Process p = null;
		String path = args[0];
//		String path = "D:\\class\\DockerTest_jars\\morning\\src\\chromedriver.exe";
		BufferedReader reader = null;
		InputStream is = null;
		System.out.println("start!");
		try {
			p = rt.exec(path);
			p.waitFor(3,TimeUnit.SECONDS);
			System.out.println("process done");
			is = p.getInputStream();
			reader = new BufferedReader(new InputStreamReader(is));
			String line = "";
			System.out.println("read start");
//			while((line = reader.readLine())!=null) {
//				System.out.println(line);
//			}
			line = reader.readLine();
			System.out.println(line);
			p.destroy();
			System.out.println("read end");
			is.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("simai");
	}
}
