package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1699 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		sol1(reader);
		// mySol(reader);

	}

	// https://velog.io/@kimmjieun/%EB%B0%B1%EC%A4%80-1699%EB%B2%88-%EC%A0%9C%EA%B3%B1%EC%88%98%EC%9D%98-%ED%95%A9-Java-%EC%9E%90%EB%B0%94
	private static void sol1(BufferedReader reader) throws IOException {
		int N = Integer.parseInt(reader.readLine());
		//
		int[] dp = new int[N + 1];
		for (int i = 1; i <= N; i++) {
			dp[i] = i;
			for (int j = 1; j * j <= i; j++) {
				if (dp[i] > dp[i - j * j] + 1) {
					dp[i] = dp[i - j * j] + 1;
				}
			}
		}

		// System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
	}

	private static void mySol(BufferedReader reader) throws IOException {
		int N = Integer.parseInt(reader.readLine());
		//
		int[] dp = new int[N + 1];
		int max = 0;
		dp[0] = 1;
		for (int i = 1; i * i <= N; i++) {
			dp[i] = i;
			if (i * i <= N) {
				dp[i * i] = 1;
				max = i;
			}
		}
		recursive(dp, N, max);
		System.out.println(Arrays.toString(dp));
	}

	private static int recursive(int[] dp, int idx, int max) {

		for (int i = 1; i <= max; i++) {
			if (idx - i * i > 0) {
				dp[idx] = Math.min(recursive(dp, idx - i * i, max) + 1, dp[idx]);
			}
		}
		return dp[idx];
	}
}
