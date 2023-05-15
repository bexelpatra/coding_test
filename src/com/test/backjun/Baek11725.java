package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek11725 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] result = new int[n+1];
		boolean[] visited = new boolean[n+1];
		List<Integer>[] arr = new ArrayList[n+1];
		StringTokenizer st = null;
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(reader.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(arr[a]==null) {
				arr[a] = new ArrayList<>();
				arr[a].add(a);
			}
			if(arr[b]==null) {
				arr[b] = new ArrayList<>();
				arr[b].add(b);
			}
			arr[a].add(b);
			arr[b].add(a);
		}
		Deque<List<Integer>> q = new LinkedList<>();
		q.add(arr[1]);
		visited[1] = true;
		List<Integer> now = null;
		while(!q.isEmpty()) {
			now = q.poll();
			for (int i = 1; i < now.size(); i++) {
				int me = now.get(0);
				int node = now.get(i);
				if(!visited[node]) {
					visited[node] = true;
					q.add(arr[node]);
					result[node] = me;
				}
			}
		}
//		System.out.println(Arrays.toString(result));
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < result.length; i++) {
			sb.append(result[i]);
			sb.append("\n");
		}
		System.out.println(sb.toString());
		
	}
}
