package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 초과가 나온다.
public class Baek4179 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];
        
        int[][] myPosition = new int[y][x];
        int[][] values = new int[y][x];
        for (int[] is : values) {
            Arrays.fill(is, Integer.MAX_VALUE);
        }
        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            map[i] = reader.readLine().toCharArray();
            for (int j = 0; j < x; j++) {
                if(map[i][j] =='F'){
                    fire.add(new int[]{i,j});
                    values[i][j]=0;
                }else if(map[i][j]=='J'){
                    q.add(new int[]{i,j});
                    myPosition[i][j] = 0;
                }
            }
        }
        boolean[][] burned = new boolean[y][x];
        int[] ny = new int[]{0,0,1,-1};
        int[] nx = new int[]{1,-1,0,0};
        
        while(!fire.isEmpty()){
            int[] now = fire.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + ny[i];
                int nextX = now[1] + nx[i];
                if(nextX<0 || nextY<0 || nextY>=y || nextX>=x){
                    continue;
                }
                if(map[nextY][nextX]!='#' && !burned[nextY][nextX]){
                    burned[nextY][nextX] = true;
                    values[nextY][nextX] = values[now[0]][now[1]] +=1;
                    fire.add(new int[]{nextY,nextX});
                }
            }
        }
        
        for (boolean[] temp : burned) {
            Arrays.fill(temp, false);
        }

        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + ny[i];
                int nextX = now[1] + nx[i];
                if(nextX<0 || nextY<0 || nextY>=y || nextX>=x){
                    System.out.println(myPosition[now[0]][now[1]] + 1);
                    return;
                }
                if(map[nextY][nextX] =='.' && !burned[nextY][nextX] && values[nextY][nextX] > myPosition[now[0]][now[1]]){
                    burned[nextY][nextX] = true;
                    myPosition[nextY][nextX] = myPosition[now[0]][now[1]] +1;
                    q.add(new int[]{nextY,nextX});
                }
            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
