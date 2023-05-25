package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1916 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
//		List<List<Integer>> list = new ArrayList<>();
		int[][] map = new int[N+1][N+1];
		PriorityQueue<Point> pq = new PriorityQueue<Baek1916.Point>();
		StringTokenizer st = null;
		for (int i = 0; i < map.length; i++) {
			Arrays.fill(map[i], -1);
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			map[y][x] = p;
		}
		st = new StringTokenizer(reader.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		for (int i = 1; i < map[from].length; i++) {
			pq.add(new Point(from,i,map[from][i]));
		}
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			for (int i = 1; i < map[now.y].length; i++) {
//				if(map[now.y][i])
				
			}
		}
	}
	static class Point implements Comparable<Point>{
		public int x;
		public int y;
		public int p;
		public Point(int x, int y, int p) {
			super();
			this.x = x;
			this.y = y;
			this.p = p;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.p - o.p;
		}
		
	}
}
