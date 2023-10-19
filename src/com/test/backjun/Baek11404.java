package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11404 {
    static final int INF = 987654321;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int node = Integer.parseInt(reader.readLine());
        int  n =Integer.parseInt(reader.readLine());
        StringTokenizer st;
        int[][] map = new int[node+1][node+1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                map[i][j] = INF;
                if(i==j) {
                    map[i][j]=0;
                };
            }
        }
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());
            map[from][to] = Math.min(map[from][to], price);

        }
        StringBuilder sb = new StringBuilder();

        for (int inter = 1; inter < node+1; inter++) {
            for (int from = 1; from < node+1; from++) {
                for (int to = 1; to < node+1; to++) {
                    if(map[from][to] > map[from][inter] + map[inter][to]){
                        map[from][to] = map[from][inter] + map[inter][to];
                    }
                }
            }
        }

        sb = new StringBuilder();
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map.length; j++) {
                if(map[i][j]==INF){
                    map[i][j]=0;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb.toString());
    }
}
