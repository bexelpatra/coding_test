package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2775 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(reader.readLine());
		int[][] dp = new int[15][15];
		for (int i = 0; i < dp[0].length; i++) {
			dp[0][i] = i;
			dp[i][1] = 1;
		}
		int[] layers = new int[T];
		int[] hos = new int[T];
		int maxL = -1;
		int maxH = -1;
		for (int i = 0; i < T; i++) {
			layers[i] = Integer.parseInt(reader.readLine());
			hos[i] = Integer.parseInt(reader.readLine());
			maxL = Math.max(maxL, layers[i]);
			maxH = Math.max(maxH, hos[i]);
		}
		StringBuilder sb = new StringBuilder();
		for (int l = 1; l < maxL+1; l++) {
			for (int h = 2; h < maxH+1; h++) {
				dp[l][h] = dp[l][h-1] + dp[l-1][h];
			}
		}
		for (int i = 0; i < T; i++) {
			sb.append(dp[layers[i]][hos[i]]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
