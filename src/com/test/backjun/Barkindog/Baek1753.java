package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1753 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int INF = 1987654321;
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(reader.readLine());

        // 채우는 값이 987654321 이면 오답이 나온다.
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);
        // Arrays.fill(dist, Integer.MAX_VALUE);

        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        List<List<int[]>> list = new ArrayList<>();
        for (int i = 0; i < n+1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            int c= Integer.parseInt(st.nextToken());
            list.get(a).add(new int[]{b,c});
        }
        pq.add(new int[]{start,0});
        dist[start]=0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(visited[now[0]]) continue;
            visited[now[0]] = true;
            for (int[] next : list.get(now[0])) {
                if(dist[next[0]] > now[1]+ next[1]){
                    dist[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0],dist[next[0]]});
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < dist.length; i++) {
            sb.append(dist[i]==INF ? "INF":dist[i]).append("\n");
        }

        System.out.println(sb.toString());
        
    }
}
