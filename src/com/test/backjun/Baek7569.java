package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek7569 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		dojob(reader);
		dojob2(reader);
		
	}
	private static void dojob(BufferedReader reader) throws IOException {
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int x =Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int h =Integer.parseInt(st.nextToken());
		
		int[][] map = new int[y*h][x];
		boolean[][] visited = new boolean[y*h][x];
		int check = 1;
		Deque<int[]> q = new LinkedList<>();
		for (int i = 0; i < y*h; i++) {
			st = new StringTokenizer(reader.readLine());
			for (int j = 0; j < x; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				check*=map[i][j];
				if(map[i][j]==1) {
					q.add(new int[] {i,j}); // y,x
					visited[i][j] =true;
				}
			}
		}
		if(check !=0 ) {
			System.out.println(0);
			return;
		}
		int size =0;
		int[] xx = new int[] {1,0,-1,0,0,0};
		int[] yy = new int[] {0,1,0,-1,y,-y};
		int count = 0;
		while(!q.isEmpty()) {
			size = q.size();
			int[] temp = null;
			int tx=0;
			int ty=0;
			for (int i = 0; i < size; i++) {
				temp = q.poll();
				for (int j = 0; j < 6; j++) {
					tx=temp[1]+xx[j];
					ty=temp[0]+yy[j];
					if(tx < 0 || ty < 0 || tx > x-1|| ty > y-1) continue;
					if(visited[ty][tx]) continue;
					visited[ty][tx] = true;
					if(map[ty][tx]!=-1) {
						map[ty][tx] = 1;
						q.add(new int[] {ty,tx});
					}
				}
			}
			print(map);
			System.out.println();
			count+=1;
		}
		if(!check(map)) {
			System.out.println(-1);
			return;
		}
		System.out.println(count);
	}
	public static void dojob2(BufferedReader reader)throws Exception {
		StringTokenizer st = new StringTokenizer(reader.readLine());
		
		int x =Integer.parseInt(st.nextToken());
		int y= Integer.parseInt(st.nextToken());
		int h =Integer.parseInt(st.nextToken());
		
		int[][][] map = new int[h][y][x];
		boolean[][][] visited = new boolean[h][y][x];
		int check = 1;
		Deque<int[]> q = new LinkedList<>();
		for (int k = 0; k < h; k++) {			
			for (int i = 0; i < y; i++) {
				st = new StringTokenizer(reader.readLine());
				for (int j = 0; j < x; j++) {
					map[k][i][j] = Integer.parseInt(st.nextToken());
					check*=map[k][i][j];
					if(map[k][i][j]==1) {
						q.add(new int[] {k,i,j}); // y,x
						visited[k][i][j] =true;
					}
				}
			}
		}
		if(check !=0 ) {
			System.out.println(0);
			return;
		}
		int[] xx = new int[] {1,0,-1,0,};
		int[] yy = new int[] {0,1,0,-1,};
		int count = 0;
		int size = 0;
		while(!q.isEmpty()) {
			size = q.size();
			System.out.println(size);
			int[] temp = null;
			int tx=0;
			int ty=0;
			int th=0;
			for (int i = 0; i < size; i++) {
				temp = q.poll();
				for (int j = 0; j < 4; j++) {
					ty=temp[1]+yy[j];
					tx=temp[2]+xx[j];
					th=temp[0];
					
					if(tx < 0 || ty < 0 || tx > x-1|| ty > y-1) continue;
					if(visited[th][ty][tx]) continue;
					visited[th][ty][tx] = true;
					if(map[th][ty][tx]!=-1) {
						map[th][ty][tx] = 1;
						q.add(new int[] {th,ty,tx});
					}
				}
				for (int j = 0; j < 2; j++) {
					th = temp[0] + (j%2 ==0? 1:-1);
					
					if(th <0 || th>h-1)continue;
					if(visited[th][temp[1]][temp[2]]) continue;
					visited[th][temp[1]][temp[2]] = true;
					if(map[th][temp[1]][temp[2]]!=-1) {
						map[th][temp[1]][temp[2]] = 1;
						q.add(new int[] {th,temp[1],temp[2]});
					}
				}
			}
			print(map);
			System.out.println();
			count+=1;
		}
		if(!check(map)) {
			System.out.println(-1);
			return;
		}
		System.out.println(count-1);
		
	}
	public static boolean check(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				if(map[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}
	public static boolean check(int[][][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				for (int j2 = 0; j2 < map[i][j].length; j2++) {					
					if(map[i][j][j2] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}
	public static void print(int[][][]map) {
		int h = map.length;
		for (int k = 0; k < h; k++) {			
			for (int i = 0; i < map[k].length; i++) {
				System.out.println(Arrays.toString(map[k][i]));
			}
		}
	}
	public static void print(int[][]map) {
		for (int i = 0; i < map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
}
