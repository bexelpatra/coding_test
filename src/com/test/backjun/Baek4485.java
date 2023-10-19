package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 녹색 옷 입은 애가 젤다지?
// 다익스트라
public class Baek4485 {
	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = 0;
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		int index = 1;
		while (true) {
			n = Integer.parseInt(reader.readLine());
			if (n == 0) {
				System.out.println(sb.toString());
				return;
			}
			int[][] map = new int[n][n];
			int[][] lowPrice = new int[n][n];
			PriorityQueue<Loc> pq = new PriorityQueue<>();
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					lowPrice[i][j] = Integer.MAX_VALUE;
				}
			}
			pq.add(new Loc(0, 0, map[0][0]));
			int[] x = new int[] { 0, 1, -1, 0 };
			int[] y = new int[] { 1, 0, 0, -1 };

			lowPrice[0][0] = map[0][0];
			while (!pq.isEmpty()) {
				Loc now = pq.poll();
				int nextX = 0;
				int nextY = 0;

				for (int i = 0; i < 4; i++) {
					nextX = now.x + x[i];
					nextY = now.y + y[i];
					if (nextX < 0 || nextY < 0 || nextX >= n || nextY >= n)
						continue;
					if (lowPrice[nextY][nextX] > lowPrice[now.y][now.x] + map[nextY][nextX]) {
						lowPrice[nextY][nextX] = lowPrice[now.y][now.x] + map[nextY][nextX];
						pq.add(new Loc(nextX, nextY, now.price + map[nextY][nextX]));
					}
				}
			}
			sb.append(String.format("Problem %s: %s\n", index++, lowPrice[n - 1][n - 1]));
		}
	}

	static class Loc implements Comparable<Loc> {
		public int x;
		public int y;
		public int price;

		public Loc(int x, int y, int price) {
			super();
			this.x = x;
			this.y = y;
			this.price = price;
		}

		@Override
		public int compareTo(Loc o1) {
			// TODO Auto-generated method stub
			return this.price - o1.price;
		}
	}
}
