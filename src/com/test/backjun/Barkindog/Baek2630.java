package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2630 {
    static int[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        StringTokenizer st ;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        recursive(n, 0, 0);
        System.out.println(zero);
        System.out.println(one);
    }
    static int zero;
    static int one;
    public static void recursive(int len,int y, int x){
        if(check(len, y, x)){
            if(map[y][x]==0){
                zero+= 1;
            }else{
                one += 1;
            }
            return;
        }
        int next = len/2;
        recursive(next, y, x);
        recursive(next, y, x+next);
        recursive(next, y+next, x);
        recursive(next, y+next, x+next);
    }

    public static boolean check(int len, int y, int x){
        int now = map[y][x];
        for (int i = y; i < y+len; i++) {
            for (int j = x; j < x+len; j++) {
                if(now != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
