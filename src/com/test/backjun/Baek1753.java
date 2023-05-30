package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1753 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int start = Integer.parseInt(reader.readLine());
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		List<List<Point>> list = new ArrayList<>();

		int[] value = new int[V+1];
		boolean[] visited= new boolean[V+1];
		
		for (int i = 0; i < V+1; i++) {
			list.add(new ArrayList<>());
		}
		Arrays.fill(value, Integer.MAX_VALUE);
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(reader.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int price = Integer.parseInt(st.nextToken());
			list.get(from).add(new Point(to,price));
		}
		pq.add(new Point(start,0));
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(visited[now.to]) continue;
			visited[now.to] = true;
			for (Point p : list.get(now.to)) {
				if(visited[p.to]) continue;
				if(value[p.to]>now.p + p.p) {
					value[p.to] = now.p + p.p;
					pq.add(new Point(p.to,value[p.to]));
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(0);
		sb.append("\n");
		for (int i = 2; i < value.length; i++) {
			sb.append(value[i]==Integer.MAX_VALUE ? "INF": value[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	
	static class Point implements Comparable<Point>{
		public int to;
		public int p;
		
		public Point(int to, int p) {
			super();
			this.to = to;
			this.p = p;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.p - o.p;
		}
		
	}
}
