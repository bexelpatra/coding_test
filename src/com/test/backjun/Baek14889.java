package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek14889 {
	// 
	private static int[][] map2;
	private static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		StringTokenizer st = null;
		int[][] map = new int[n][n];
		map2 = new int[n][n];
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				map2[i][j] = map[i][j];
			}
		}
		combi(new boolean[n],0,0);
		System.out.println(min);
	}
	public static void combi(boolean[] visited,int idx, int count) {
		if(visited.length/2==count) {
			// do something
			diff(visited);
			return;
		}
		for (int i = idx; i < visited.length; i++) {
			if(!visited[idx]) {
				visited[i] = true;
				combi(visited,idx+1,count+1);
				visited[i] = false;
			}
		}
	}
	public static void diff(boolean[] visited) {
		int star = 0;
		int link = 0;
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited.length; j++) {
				if(visited[i] && visited[j]) {
					star+=map2[i][j];
					star+=map2[j][i];
				}else if(!visited[i]&&!visited[j]) {
					link+=map2[i][j];
					link+=map2[j][i];
				}
			}
		}
		int temp = star - link;
		if (temp ==0) {
			min = 0;
			return;
		}
		if(temp <0) {
			temp*=-1;
		}
		min = Math.min(min , temp);
	}
}
