package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek16398_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        int[][] map = new int[n+1][n+1];
        boolean[] visitied = new boolean[n+1];
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        StringTokenizer st;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        long answer =0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{1,1});
        dist[1] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int from = now[0];
            visitied[from] = true;

            for (int next = 1; next < n+1; next++) {
                if(!visitied[next] && map[from][next] !=0 && map[from][next] < dist[next]){
                    dist[next] = map[from][next];
                    pq.add(new int[]{next,dist[next]});
                }
            }
        }
        for (int i = 1; i < n+1; i++) {
            answer += dist[i];
        }

        System.out.println(answer);
    }
    
}
