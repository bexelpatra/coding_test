package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek7562 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int loop = Integer.parseInt(reader.readLine());
		for (int i = 0; i < loop; i++) {
			dojob(reader);
		}
	}
	public static void dojob(BufferedReader reader) throws Exception{
		int i=Integer.parseInt(reader.readLine());
		int[] nextY = {2,2,1,1,-2,-2,-1,-1};
		int[] nextX = {1,-1,2,-2,1,-1,2,-2};
		int[] position = new int[4];
		StringTokenizer st = null;

		for (int j = 0; j < position.length; j++) {
			if(j%2==0) {
				st = new StringTokenizer(reader.readLine());
			}
			position[j] = Integer.parseInt(st.nextToken());
		}

		if(position[0]==position[2]&&position[1]==position[3]) {
			System.out.println(0);
			return;
		}
		
		Deque<int[]> q = new LinkedList<>();
		q.add(new int[] {position[0],position[1],0});
		boolean[][] flag = new boolean[i][i];
		int c = 0;
		int[] yx=null;
		while(!q.isEmpty()) {
			yx = q.poll();
			if(flag[yx[0]][yx[1]]) {
				continue;
			}
			flag[yx[0]][yx[1]] = true;
			if(yx[0] == position[2] && yx[1]== position[3]) {
				break;
			}
			
			for (int j = 0; j < 8; j++) {
				int nX = yx[0]+nextX[j];
				int nY = yx[1]+nextY[j];
				
				if(nX <0 || nY<0 || nX>i-1 || nY>i-1) {
					continue;
				}else {
					q.add(new int[]{nX,nY,yx[2]+1});
				}
			}
			
		}
		System.out.println(yx[2]);
//		dfs(map,new boolean[i][i], position[0], position[1],0);
	}
	
	// overflow로 터져버린다...
//	public static void dfs(int[][] map,boolean[][] visited,int x, int y,int count) {
//		if(map.length-1< x || map.length-1< y || x<0 || y<0) {
//			return;
//		}
//		System.out.println(String.format("x : %d, y : %d, count : %d => %s", x,y,count,visited[y][x] ? "visited":"never"));
//		if(visited[y][x]) {
//			map[y][x] = Math.min(map[y][x], count);
//			return;
//		}
//		visited[y][x] = true;
//		//right
//		dfs(map, visited, x+2, y+1, count+1);
//		dfs(map, visited, x+2, y-1, count+1);
//		//up
//		dfs(map, visited,x+1, y+2, count+1);
//		dfs(map, visited,x-1, y+2, count+1);
//		//down
//		dfs(map, visited,x+1, y-2, count+1);
//		dfs(map, visited,x-1, y-2, count+1);
//		//left
//		dfs(map, visited,x-2, y+1, count+1);
//		dfs(map, visited,x-2, y-1, count+1);
//		
//	}
}
