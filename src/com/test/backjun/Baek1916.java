package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1916 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try3(reader);
//		try2(reader);
//		outOfMemory(reader);
	}
	private static void try3(BufferedReader reader) throws Exception{
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());

		boolean[] visited = new boolean[N+1];
		int[] values = new int[N+1];
		
		List<List<Point>> list = new ArrayList<>();
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		StringTokenizer st = null;
		for (int i = 0; i < N+1; i++) {
			list.add(new ArrayList<>());
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			list.get(from).add(new Point(from, to, p));
		}
		st = new StringTokenizer(reader.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		Arrays.fill(values, Integer.MAX_VALUE);

		pq.add(new Point(0,from,0));
		values[from] = 0;

		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			int cur = now.to;
			if(visited[cur])continue;
			visited[cur] = true;
			for (Point point : list.get(cur)) {
				if(!visited[point.to] && values[point.to] > values[cur] + point.p) {
					values[point.to] = values[now.to] + point.p;
					pq.add(new Point(from, point.to, values[point.to]));
				}
			}
		}
//		System.out.println(Arrays.toString(values));
		System.out.println(values[to]);
		
	}
	private static void try2(BufferedReader reader) throws Exception{
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
		Map<Integer,Map<Integer,Integer>> map = new HashMap<>();
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		StringTokenizer st = null;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			if(map.get(y) == null) {
				map.put(y, new HashMap<>());
			}
			if(map.get(y).get(x)!=null) {
				map.get(y).put(x, map.get(y).get(x)>p? p:map.get(y).get(x));
			}else {
				map.get(y).put(x, p);				
			}
		
		}
		st = new StringTokenizer(reader.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		for (Integer i : map.get(from).keySet()) {
			pq.add(new Point(i, from, map.get(from).get(i)));
		}
		
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			if(map.get(now.from)== null) continue;
			for (Integer key :  map.get(now.from).keySet()) {
				if(map.get(now.from).get(key) + now.p< map.get(from).getOrDefault(key,Integer.MAX_VALUE) ) {
					
					map.get(from).put(key, map.get(now.from).get(key) + now.p);
					pq.add(new Point(from,key, map.get(now.from).get(key) + now.p));
				}
			}
		}
		for (int ki: map.keySet()) {
			for (int ki2: map.get(ki).keySet()) {
				System.out.println(String.format("y : %d x : x : %d price : %d", ki,ki2,map.get(ki).get(ki2)));
			}
		}
		System.out.println(map.get(from).get(to));
	}
	private static void outOfMemory(BufferedReader reader) throws IOException {
		int N = Integer.parseInt(reader.readLine());
		int M = Integer.parseInt(reader.readLine());
//		List<List<Integer>> list = new ArrayList<>();
		int[][] map = new int[N+1][N+1];
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		StringTokenizer st = null;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(reader.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			map[y][x] = p;
//			map[x][y] = p;
		}
		st = new StringTokenizer(reader.readLine());
		int from = Integer.parseInt(st.nextToken());
		int to = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i < map[from].length; i++) {
			pq.add(new Point(from,i,map[from][i]));
		}
		int temp = 0;
		boolean[] visited = new boolean[N+1];
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			for (int dest = 1; dest < map[now.to].length; dest++) {
				if(visited[now.to]) continue;
				if(map[now.to][dest] != 0
						&& map[now.to][dest] + now.p < map[from][dest]
								|| map[from][dest]==0) {
					visited[now.to] = true;
					temp = map[now.to][dest] + now.p;
					map[from][dest] =  temp;
//					map[dest][from] =  temp;
					pq.add(new Point(from, dest, temp));
				}
				
			}
		}
//		for (int i = 1; i < map.length; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		System.out.println(map[from][to]);
	}
	static class Point implements Comparable<Point>{
		public int from;
		public int to;
		public int p;
		public Point(int x, int y, int p) {
			super();
			this.from = x;
			this.to = y;
			this.p = p;
		}
		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return  this.p - o.p;
		}
		
	}
}
