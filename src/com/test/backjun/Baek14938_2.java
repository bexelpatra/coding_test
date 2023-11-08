package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek14938_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int v = Integer.parseInt(st.nextToken());
        int[][] map = new int[v+1][v+1];
        int target = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        // for (int i = 0; i < map.length; i++) {
        //     Arrays.fill(map[i], Integer.MAX_VALUE);
        //     map[i][i]=0;
        // }

        int[] items = new int[v+1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < items.length; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            map[from][to] = val;
            map[to][from] = val;
        }

        for (int stopover = 1; stopover < v+1; stopover++) {
            for (int from = 1; from < v+1; from++) {
                for (int to = 1; to < v+1; to++) {
                    if(map[from][to] > map[from][stopover] + map[stopover][to]){
                        map[from][to] = map[from][stopover] + map[stopover][to];
                    }
                }
            }
        }
        int total =0;
        int temp = 0;
        for (int i = 1; i < v+1; i++) {
            temp=0;
            for (int j = 1; j < v+1; j++) {
                // if(map[i][j] <= target && map[i][j]!=0){ // map[i][j] == 0 인것도 들어가야 한다. 시작점이므로...
                //     temp += items[j];
                // }
                if(map[i][j] <= target){
                    temp += items[j];
                }
            }
            total = Math.max(total,temp);
        }
        System.out.println(total);
    }

}
