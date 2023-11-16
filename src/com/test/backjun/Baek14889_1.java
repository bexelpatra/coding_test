package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14889_1 {
    static int[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        StringTokenizer st ;
        for (int y = 0; y < n; y++) {
            st = new StringTokenizer(reader.readLine());
            for (int x = 0; x < n; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        teaming(new boolean[n], 0, 0);
        System.out.println(total);
    }
    static int total = Integer.MAX_VALUE;
    public static void teaming(boolean[] visited,int idx,int count){
        if(count  == visited.length/2){
            // 계산
            calc(visited);
            return;
        }
        for (int i = idx; i < visited.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                teaming(visited,i+1,count+1);
                visited[i] = false;
            }
        }
    }
    public static void calc(boolean[] teamA){
        int a = 0;
        int b = 0;
        for (int y = 0; y < teamA.length; y++) {
            for (int x = 0; x < teamA.length; x++) {
                if(teamA[y] && teamA[x]){
                    a += map[y][x];
                }else if(!teamA[y]&&!teamA[x]){
                    b += map[y][x];
                }
            }
        }
        if(a>b){
            total = Math.min(total, a-b);
        }else{
            total = Math.min(total, b-a);
        }
    }
}
