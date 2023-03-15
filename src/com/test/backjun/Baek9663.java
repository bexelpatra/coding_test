package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek9663 {

	static int[] moveX = { 1, 1, -1, -1 };
	static int[] moveY = { 1, -1, 1, -1 };
	static int N = 0;

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		int total = 0;
		boolean[][] map = new boolean[N][N];

		
		System.out.println(total);

	}
	private static void pick(boolean[][] map, int x, int y) {
		if(!map[x][y]) {
			removeX(map, x);
			removeY(map, y);
			removeCross(map, x, y);
		}else {
			
		}
	}
	
	private static void removeY(boolean[][] map, int y) {
		for (int i = 0; i < map[y].length; i++) {
			map[y][i] = true;
		}
	}

	private static void removeX(boolean[][] map, int x) {
		for (int i = 0; i < map.length; i++) {
			map[i][x] = true;
		}
	}

	private static void removeCross(boolean[][] map, int x, int y) {
		int tempX = x;
		int tempY = y;
		for (int i = 0; i < 4; i++) {
			while (true) {
				if (tempX < 0 || tempY < 0)
					break;
				if (tempX > N - 1 || tempY > N - 1)
					break;
				map[tempX][tempY] = true;
				tempX += moveX[i];
				tempY += moveY[i];
			}
			tempX = x;
			tempY = y;
		}
	}
	
	private static void pprint(boolean[][] map) {
		StringBuilder sb = new StringBuilder();
		for (boolean[] bs : map) {
			for (boolean b : bs) {
				if(b) {
					sb.append("0");					
				}else {					
					sb.append("1");					
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
