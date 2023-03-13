package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek15904 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String words = reader.readLine().replaceAll(" ", "");
				
		char[] c = {'U','C','P','C'};
		String yes = "I love UCPC";
		String no = "I hate UCPC";
		int idx = 0;
		for (int i = 0; i < words.length(); i++) {
			if(words.charAt(i) == c[idx]) {
				idx++;
			}
			if(idx == 4) {
				System.out.println(yes);
				return;
			}
		}
		System.out.println(no);
		
	}
}
