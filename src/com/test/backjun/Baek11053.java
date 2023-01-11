package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11053 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] list = new int[n];
		int[] dpLeft = new int[n];
		int[] dpRight= new int[n];
		StringTokenizer st= new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			dpLeft[i] = 1;
			dpRight[n-i-1] = 1;
			for (int j = 0; j < i; j++) {
				if (list[j] < list[i] && dpLeft[j]+1 >dpLeft[i]) {
					dpLeft[i] = dpLeft[j] + 1;
				}
			}
			for (int j = n-1; j >= n-i-1; j--) {
				if (list[j] < list[ n-i-1] && dpRight[j]+1 >dpRight[n-i-1]) {
					dpRight[n-i-1] = dpRight[j] + 1;
				}
			}
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int max = -1;
		for (int i = 0; i < n; i++) {
			int temp = dpLeft[i]+dpRight[i];
			max = Math.max(temp, max);
		}
		System.out.println(sb1.toString());
		System.out.println(sb2.toString());
		System.out.println(max);
		
	}
}
