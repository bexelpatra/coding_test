package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 분할 정복...
 */
public class Baek1780 {
    static int[][] map;
    static int zero,po,ne;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new int[n][n];

        StringTokenizer st ;
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(reader.readLine());
            for (int x = 0; x < n; x++) {
                int now = Integer.parseInt(st.nextToken());
                map[y][x] = now ;
            }
        }
    
        recur(n, 0, 0);
        System.out.println(ne);
        System.out.println(zero);
        System.out.println(po);
    }
    public static void recur(int n, int y, int x){
        int now = map[y][x];
        if(check(n, y, x)){
            if(now== 0){
                zero+=1;
            }else if(now==1){
                po+=1;
            }else if(now ==-1){
                ne+=1;
            }
            return;
        }
        int next = n/3;

        recur(next, y,x);
        recur(next, y,x + next);
        recur(next, y,x + next*2);

        recur(next, y + next,x);
        recur(next, y + next,x + next);
        recur(next, y + next,x + next*2);

        recur(next, y + next*2,x);
        recur(next, y + next*2,x + next);
        recur(next, y + next*2,x + next*2);
    }
    public static boolean check(int n,int y, int x) {
		int now = map[y][x];
 
		for (int i = y; i < y + n; i++) {
			for (int j = x; j < x + n; j++) {
				if (now != map[i][j]) {
					return false;
				}
			}
		}
		return true;
	}
}
