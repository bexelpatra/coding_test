package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11660 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int[][] map = new int[n+1][n+1];
		int[][] dp = new int[n+1][n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(reader.readLine());
			int tmm = 0;
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				tmm +=map[i][j];
				dp[i][j] = tmm;
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < y; i++) {
			st = new StringTokenizer(reader.readLine());
			Point t = new Point();
			
			t.from.y = Integer.parseInt(st.nextToken());
			t.from.x = Integer.parseInt(st.nextToken());
			t.to.y = Integer.parseInt(st.nextToken());
			t.to.x = Integer.parseInt(st.nextToken());
			int ans = 0;
			for (int j = t.from.y; j <= t.to.y; j++) {
				ans +=dp[j][t.to.x] - dp[j][t.from.x-1];
			}
			sb.append(ans)
			  .append("\n");
		}
		System.out.println(sb.toString());
	}
	static class Point{
		class from{
			public int x;
			public int y;
			public from() {
			}
		}
		class to{
			public int x;
			public int y;
			public to() {
			}
		}
		public from from;
		public to to;
		public Point() {
			from = new from();
			to = new to();
		}
	}
}
