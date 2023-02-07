package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1343 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		char[] line = reader.readLine().toCharArray();
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		
		
		for (int i = 0; i < line.length; i++) {
			char c = line[i];
			if('.'==c ) {
				if(temp ==0) {
					sb.append(".");
					continue;
				}
				if(temp %2 !=0) {
					System.out.println(-1);
					return;
				}
				for (int j = 0; j < temp/4; j++) {
					sb.append("AAAA");
				}
				if(temp%4 ==2) {
					sb.append("BB");
				}
				sb.append(".");
				temp=0;
			}else {
				temp+=1;
			}
		}
		if(temp %2 !=0) {
			System.out.println(-1);
			return;
		}
		for (int j = 0; j < temp/4; j++) {
			sb.append("AAAA");
		}
		if(temp%4 ==2) {
			sb.append("BB");
		}
		System.out.println(sb.toString());
	}
}
