package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1926 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];
        boolean[][] visited = new boolean[y][x];
        for (int i = 0; i < y; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < x; j++) {
                map[i][j] = st.nextToken().charAt(0);
            }
        }
        // 탐색 시작
        int[] ny = {0,0,-1,1};
        int[] nx = {1,-1,0,0};
        int count = 0;
        int max = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if(map[i][j]=='1' && !visited[i][j]){ // 안 들렀고 1인 경우
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    visited[i][j] = true;
                    int size = 0;
                    while(!q.isEmpty()){
                        int[] now = q.poll();
                        size+=1;
                        for (int k = 0; k < 4; k++) {
                            int nextY = now[0]+ny[k];
                            int nextX = now[1]+nx[k];
                            if(nextX <0 || nextY<0 || nextX >=x || nextY >=y){
                                continue;
                            }
                            if(!visited[nextY][nextX] && map[nextY][nextX]=='1'){
                                visited[nextY][nextX] = true;
                                q.add(new int[]{nextY, nextX});
                            }
                        }
                    }
                    // System.out.println(size);
                    max = Math.max(max,size);
                    count+=1;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(count).append("\n").append(max);
        System.out.println(sb.toString());
    }
}
