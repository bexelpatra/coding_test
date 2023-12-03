package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Baek1941 {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        map = new char[5][];
        for (int i = 0; i < 5; i++) {
            map[i] = reader.readLine().toCharArray();
        }
        choose(new int[7], new boolean[25], 0, 0,0);
        System.out.println(count);
    }
    static int count =0;
    public static void choose(int[] result,boolean[] used,int idx,int start,int sCount){
        if(idx == result.length){
            if(sCount>=4 && chained(result)){
                count+=1;
            }
            return;
        }

        for (int i = start; i < used.length; i++) {
            if(!used[i]){
                used[i] = true;
                result[idx] = i;
                if(map[i/5][i%5]=='S'){
                    sCount+=1;
                }
                choose(result,used,idx+1,i+1,sCount);
                if(map[i/5][i%5]=='S'){
                    sCount-=1;
                }
                used[i] = false;
            }
        }
    }
    
    static int[] nextY = {0,0,1,-1};
    static int[] nextX = {1,-1,0,0};
    static boolean[][] isConn = new boolean[5][5];
    static boolean[][] visited = new boolean[5][5];

    public static boolean chained(int[] arr){
        for (int i = 0; i < 5; i++) {
            Arrays.fill(isConn[i], false);
            Arrays.fill(visited[i], false);
        }

        int count =0;

        for (int i = 0; i < arr.length; i++) {
            isConn[arr[i]/5][arr[i]%5] = true;
        }

        int[] start = new int[]{arr[0]/5,arr[0]%5};
        count+=1;

        Queue<int[]> q = new LinkedList<>();
        visited[start[0]][start[1]] = true;
        q.add(start);
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + nextY[i];
                int nx = now[1] + nextX[i];
                if(ny <0 || nx<0 || ny>4 || nx>4){
                    continue;
                }
                if(isConn[ny][nx] && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    q.add(new int[]{ny,nx});
                    count+=1;
                }
            }
        }
        return count ==7 ;
    }

}
