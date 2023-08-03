package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

// 벽부수고 이동하기
public class Baek2206 {
	static class Loc {
		public int x;
		public int y;
		public boolean destroyed;

		public Loc(int x, int y, boolean destroyed) {
			super();
			this.x = x;
			this.y = y;
			this.destroyed = destroyed;
		}

	}

	// https://velog.io/@yanghl98/%EB%B0%B1%EC%A4%80-2206-%EB%B2%BD-%EB%B6%80%EC%88%98%EA%B3%A0-%EC%9D%B4%EB%8F%99%ED%95%98%EA%B8%B0-JAVA%EC%9E%90%EB%B0%94
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs = br.readLine().split(" ");

		int n = Integer.parseInt(inputs[0]); // y
		int m = Integer.parseInt(inputs[1]); // x

		char[][] map = new char[n][m];
		for (int i = 0; i < n; i++) {
			String input = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		Queue<Loc> q = new LinkedList<>();
		q.add(new Loc(0, 0, false));

		int[] mx = { 0, 0, -1, 1 };
		int[] my = { -1, 1, 0, 0 };
		boolean[][][] visited = new boolean[n][m][2];

		int count = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Loc now = q.poll();

				// System.out.println(now.x + " : "+now.y);
				if (now.y == n - 1 && now.x == m - 1) {
					System.out.println(count);
					return;
				}
				for (int j = 0; j < 4; j++) {
					int nextX = now.x + mx[j];
					int nextY = now.y + my[j];
					if (nextX < 0 || nextY < 0 || nextX + 1 > m || nextY + 1 > n)
						continue;
					if (map[nextY][nextX] == '0') { // 길
						if (!visited[nextY][nextX][0] && !now.destroyed) { // 안부수고 와본적이 있는가
							q.add(new Loc(nextX, nextY, false));
							visited[nextY][nextX][0] = true;
						} else if (!visited[nextY][nextX][1] && now.destroyed) { // 부수고 와본적이 있는가
							q.add(new Loc(nextX, nextY, true));
							visited[nextY][nextX][1] = true;
						}

					} else if (map[nextY][nextX] == '1') { // 벽
						// 벽인데 부순적 없으면? -> 부수고 진행한다.
						if (!now.destroyed) {
							q.add(new Loc(nextX, nextY, true));
							visited[nextY][nextX][1] = true;
						}
					}
				}
			}
			count += 1;
			// System.out.println();
		}
		System.out.println(-1);
	}
}
