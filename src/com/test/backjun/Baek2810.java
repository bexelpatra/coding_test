package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2810 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(reader.readLine());
		String line = reader.readLine();
		
		int count =0 ;
		if(num <6) {
			System.out.println(num);
			return;
		}
		
		for (int i = 0; i < num; i++) {
			
			if( line.charAt(i) =='L') {
				i+=1;
			}
			count+=1;
		}
		System.out.println(count+1);
	}

}
