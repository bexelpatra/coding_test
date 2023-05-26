package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1916 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		try2(reader);
//		outOfMemory(reader);
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
			if(map.get(now.x)== null) continue;
			for (Integer key :  map.get(now.x).keySet()) {
				if(map.get(now.x).get(key) + now.p< map.get(from).getOrDefault(key,Integer.MAX_VALUE) ) {
					
					map.get(from).put(key, map.get(now.x).get(key) + now.p);
					pq.add(new Point(from,key, map.get(now.x).get(key) + now.p));
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
		while(!pq.isEmpty()) {
			Point now = pq.poll();
			for (int dest = 1; dest < map[now.y].length; dest++) {
				if(map[now.y][dest] != 0
						&& map[now.y][dest] + now.p < map[from][dest]
								|| map[from][dest]==0) {
					temp = map[now.y][dest] + now.p;
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
			return  this.p - o.p;
		}
		
	}
}
