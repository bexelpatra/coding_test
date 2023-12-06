package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 초과가 나온다.
//https://www.acmicpc.net/source/65638848 를 참고하면서 다시 도전해보자
public class Baek4179_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] map = new char[y][x];
        
        int[][] jDist = new int[y][x];
        int[][] fDist = new int[y][x];
      
        Queue<int[]> fire = new LinkedList<>();
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < y; i++) {
            map[i] = reader.readLine().toCharArray();
            for (int j = 0; j < x; j++) {

                fDist[i][j] = -1;
                jDist[i][j] = -1;
                if(map[i][j] =='F'){
                    fire.add(new int[]{i,j});
                    fDist[i][j]=0;
                }else if(map[i][j]=='J'){
                    q.add(new int[]{i,j});
                    jDist[i][j] = 0;
                }
            }
        }
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
                if(map[nextY][nextX] =='#' || fDist[nextY][nextX]>=0){
                    continue;
                }
                fDist[nextY][nextX] = fDist[now[0]][now[1]] + 1;
                fire.add(new int[]{nextY,nextX});
               
            }
        }
        while(!q.isEmpty()){
            int[] now = q.poll();
            for (int i = 0; i < 4; i++) {
                int nextY = now[0] + ny[i];
                int nextX = now[1] + nx[i];
                if(nextX<0 || nextY<0 || nextY>=y || nextX>=x){
                    System.out.println(jDist[now[0]][now[1]] + 1);
                    return;
                }
                if(map[nextY][nextX] =='#' || jDist[nextY][nextX]>=0){ // 이미 들렀거나 벽인 경우
                    continue;
                }
                if(fDist[nextY][nextX] <= jDist[now[0]][now[1]] +1 && fDist[nextY][nextX] !=-1){ // 
                    continue;
                }
                q.add(new int[]{nextY,nextX});
                jDist[nextY][nextX] = jDist[now[0]][now[1]] +1;
            }
        }
        System.out.println("IMPOSSIBLE");

    }
}
