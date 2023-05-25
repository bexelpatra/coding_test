package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CMD {

	public static void main(String[] args) {
		Process p ;
		BufferedReader reader;
		System.out.println("started");
		try {
			p = Runtime.getRuntime().exec("cmd -c wget https://dl.google.com/linux/direct/google-chrome-stable_current_amd64.deb");
			reader= new BufferedReader(new InputStreamReader(p.getInputStream()));
			print(reader);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("done");
	}
	public static void print(BufferedReader reader) throws Exception{
		String line ="";
		while((line = reader.readLine())!=null) {
			System.out.println(line);
		}
	}
}
