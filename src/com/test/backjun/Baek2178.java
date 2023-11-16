package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        char[][] map = new char[y][];
        for (int i = 0; i < map.length; i++) {
            map[i] = reader.readLine().toCharArray();
        }

        Deque<int[]> dq  = new ArrayDeque<>();
        boolean[][] visited = new boolean[y][x];
        dq.add(new int[]{0,0,1});
        int[] ny = new int[]{0,0,1,-1};
        int[] nx = new int[]{1,-1,0,0};
        while(!dq.isEmpty()){
            int[] now = dq.poll();
            if(now[0] == y-1 && now[1]==x-1){
                System.out.println(now[2]);
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nextY = now[0]+ ny[i];
                int nextX = now[1]+ nx[i];
                if(nextX >=x || nextY>=y || nextX<0||nextY<0){
                    continue;
                }
                if(!visited[nextY][nextX] && map[nextY][nextX] =='1'){
                    visited[nextY][nextX]= true;
                    dq.add(new int[]{nextY,nextX,now[2]+1});
                }
            }
        }
    }
}
