package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek9663 {

	static int[] moveX = { 1, 1 };
	static int[] moveY = { 1,-1 };
	static int N = 0;
	static int count =0;
	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(reader.readLine());
		int total = 0;
		boolean[][] map = new boolean[N][N];

		pick(map, 0, 0);
		System.out.println(count);

	}
	private static void pick(boolean[][] map, int x, int y) {
		if(x==N-1) {
			count+=1;
			return;
		}
		for (int i = 0; i < N; i++) {
			if(!map[x][i]) {
				removeY(map, i,true);
				removeCross(map, x, i, true);
				
				System.out.printf("x : %d , y : %d\n",x,i);
				pprint(map);
				pick(map, x+1, i);
				
				removeY(map, i,false);
				removeCross(map, x, i, false);
			}
		}
	}
	
	private static void removeX(boolean[][] map, int y) {
		for (int i = 0; i < map[y].length; i++) {
			map[y][i] = true;
		}
	}

	private static void removeY(boolean[][] map, int x,boolean flag) {
		for (int i = 0; i < map.length; i++) {
			map[i][x] = flag;
		}
	}

	private static void removeCross(boolean[][] map, int x, int y,boolean flag) {
		int tempX = x;
		int tempY = y;
		for (int i = 0; i < 2; i++) {
			while (true) {
				tempX += moveX[i];
				tempY += moveY[i];				
				if (tempX < 0 || tempY < 0)
					break;
				if (tempX > N - 1 || tempY > N - 1)
					break;

				map[tempX][tempY] = flag;
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
					sb.append("0 ");					
				}else {					
					sb.append("1 ");					
				}
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
