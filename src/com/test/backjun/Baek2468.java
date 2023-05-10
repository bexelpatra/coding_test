package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2468 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader=  new  BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[][] map = new int[n][n];
		StringTokenizer st = null;
		
		int maxH = -1;
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < map.length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				maxH=Math.max(maxH, map[i][j]);
			}
		}
		boolean[][] visited = null;
		int[] arr = new int[maxH];
		int result = 0;
		System.out.println("maxH : "+maxH);
		for (int i = 0; i <= maxH; i++) {
			visited = new boolean[n][n];
			int now = 0;
			for (int y = 0; y < visited.length; y++) {
				for (int x = 0; x < visited.length; x++) {
					if(!visited[y][x] && map[y][x]>i) {
						dfs(map, visited, x, y,i);
						arr[i]+=1;
						now+=1;
					}
				}
			}
			result = Math.max(result, now);
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(result);
	}
	public static void dfs(int[][] map, boolean[][] visited, int x, int y,int h) {
		if(x+1>map.length || y+1 >map.length || x<0|| y<0) {
			return;
		}
		if(map[y][x] <=h) {
			return;			
		}
		if(visited[y][x]) {
			return;
		}
		visited[y][x] = true;
		dfs(map, visited, x+1, y,h);
		dfs(map, visited, x-1, y,h);
		dfs(map, visited, x, y+1,h);
		dfs(map, visited, x, y-1,h);
	}
}
