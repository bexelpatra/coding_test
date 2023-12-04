package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek7576 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y=  Integer.parseInt(st.nextToken());
        int[][] map = new int[y][x];
        int count =0;
        int days =0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < x; j++) {
                int temp = Integer.parseInt(st.nextToken());
                map[i][j] = temp;
                if(temp ==0){
                    count +=1;
                }else if(temp ==1){
                    count+=1;
                    q.add(new int[]{i,j,0});
                }
            }
        }
        
        // count 가 0이 안되면 -1 이다
        int[] ny = new int[]{0,0,1,-1};
        int[] nx = new int[]{1,-1,0,0};
    
        while(!q.isEmpty()){
            int[] now= q.poll();
            visited[now[0]][now[1]] = true;
            count -=1;
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + ny[i];
                int nextX = now[1] + nx[i];
                if(nextX <0 || nextY < 0 || nextX>=x || nextY >=y){
                    continue;
                }
                if(!visited[nextY][nextX] && map[nextY][nextX]==0){
                    visited[nextY][nextX] = true;
                    q.add(new int[]{nextY,nextX,now[2]+1});
                    days = now[2]+1;
                }
            }
        }
        // for (boolean[] inner : visited) {
        //     System.out.println(Arrays.toString(inner));
        // }
        // System.out.println(count);
        if(count==0){
            System.out.println(days);
        }else{
            System.out.println(-1);
        }
        
    }
}
