package com.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
3
7
13 10 12 11 10 11 12
5
2 4 5 7 9
8
6 6 6 6 6 6 6 6
 */
public class Baek11497 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		int loop = Integer.parseInt(reader.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < loop; i++) {
			sb.append(sol1(reader));
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static int sol1(BufferedReader reader) throws Exception{
		int n = Integer.parseInt(reader.readLine());
		int[] result = new int[n];
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine()); 
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
		
		for (int i = 0; i < (result.length)/2; i++) {
			result[i] = arr[i*2];
			result[result.length-i-1] = arr[i*2+1]; 
		}
		if(n%2==1) {
			result[(n+1)/2-1] = arr[n-1];
		}
		int max = 0;
		for (int i = 0; i < result.length-1; i++) {
			int x = Math.abs((result[i] - result[i+1]));
			max = Math.max(max, x);
		}
		return max;
	}
}
