package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Baek11053 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] nums = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		Integer[] dp = null;
		dp = new Integer[n];
		for (int i = 0; i < n; i++) {
			if (dp[i] == null) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (nums[j] < nums[i] && dp[j] + 1 > dp[i]) {
						dp[i] = dp[j] + 1;
					}
//					System.out.println(Arrays.toString(dp));
				}
			}
		}
		int answer = Arrays.stream(dp)
							.max(Comparator.naturalOrder())
							.get();
		System.out.println(answer);
//		my1(reader);
//		method2(reader);
	}

	private static void method2(BufferedReader reader) throws IOException {
		int n = Integer.parseInt(reader.readLine());
		int[] nums = new int[n];
		StringTokenizer token = new StringTokenizer(reader.readLine(), " ");
		for (int i = 0; i < nums.length; i++) {
			nums[i] = Integer.parseInt(token.nextToken());
		}
		Integer[] dp = null;
		dp = new Integer[n];
		for (int i = 0; i < n; i++) {
			LIS(i, nums, dp);
		}
		int max = dp[0];
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(max, dp[i]);
		}
		System.out.println(max);
	}

	static int LIS(int N, int[] seq, Integer[] dp) {

		// 만약 탐색하지 않던 위치의 경우
		if (dp[N] == null) {
			dp[N] = 1; // 1로 초기화

			// N-1 부터 0까지중 N보다 작은 값들을 찾으면서 재귀호출.
			for (int i = N - 1; i >= 0; i--) {
				if (seq[i] < seq[N]) {
					dp[N] = Math.max(dp[N], LIS(i, seq, dp) + 1);
				}
			}
		}
		return dp[N];
	}

	private static void my1(BufferedReader reader) throws IOException {
		int n = Integer.parseInt(reader.readLine());
		int[] list = new int[n];
		int[] dpLeft = new int[n];
		int[] dpRight = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			list[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < n; i++) {
			dpLeft[i] = 1;
			dpRight[n - i - 1] = 1;
			for (int j = 0; j < i; j++) {
				if (list[j] < list[i] && dpLeft[j] + 1 > dpLeft[i]) {
					dpLeft[i] = dpLeft[j] + 1;
				}
			}
			for (int j = n - 1; j >= n - i - 1; j--) {
				if (list[j] < list[n - i - 1] && dpRight[j] + 1 > dpRight[n - i - 1]) {
					dpRight[n - i - 1] = dpRight[j] + 1;
				}
			}
		}
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		int max = -1;
		for (int i = 0; i < n; i++) {
			int temp = dpLeft[i]
//					+dpRight[i]
			;
			max = Math.max(temp, max);
		}
//		System.out.println(sb1.toString());
//		System.out.println(sb2.toString());
		System.out.println(max);
	}
}
