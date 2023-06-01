package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11055 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		int[] dp = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < n; i++) {
			dp[i] = arr[i];
			for (int j = 0; j < i; j++) {
				if(arr[j] < arr[i] && dp[j] + arr[i] > dp[i]) {
					dp[i] = dp[j]+arr[i];
				}
			}
		}
		int max = Arrays.stream(dp).max().getAsInt();
		System.out.println(max);
	}
}
