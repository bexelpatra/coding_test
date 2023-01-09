package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek12904 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		extracted2(reader);
		
		
	}
	private static void extracted2(BufferedReader reader) throws IOException {
		String target = reader.readLine();
		String src = reader.readLine();
		int len =  src.length();
		
		StringBuffer sb = new StringBuffer(src);
		while(len !=target.length()) {
			len-=1;
			if(sb.charAt(len)=='B') {
				sb.deleteCharAt(len);
				sb = sb.reverse();
			}else {
				sb.deleteCharAt(len);
			}
		}
		if(sb.toString().equals(target)) {
			System.out.println(1);
		}else {
			System.out.println(0);
			
		}
	}
	private static void extracted(BufferedReader reader) throws IOException {
		String target = reader.readLine();
		String src = reader.readLine();
		int len =  src.length();
		boolean isReverse = false;
		int left =0;
		int right = len;
		while(len !=target.length()) {
			int now =0;
			if(isReverse) {
				left+=1;
				now = left;
			}else {
				right-=1;
				now = right;
			}
			
			if(src.charAt(now)=='B') {
				isReverse = !isReverse; 
			}			
			len-=1;
		
			// debuf
			String temp = src.substring(left, right);
			if(isReverse) {
				StringBuffer sb = new StringBuffer(temp);
				temp = sb.reverse().toString();
			}
			System.out.println(temp);
		}
		
		src = src.substring(left, right);
		
		if(isReverse) {
			StringBuffer sb = new StringBuffer(src);
			src = sb.reverse().toString();
		}else {
//			System.out.println(src.equals(target));
		}
		
		System.out.println(src);
		if(src.equals(target)) {
			System.out.println(1);
		}else {
			System.out.println(0);
		}
	}

}
