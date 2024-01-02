package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek11779 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int INF = Integer.MAX_VALUE;
        int[] dist = new int[n+1];
        Arrays.fill(dist, INF);

        List<int[]>[] list = new List[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        StringTokenizer st ;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new int[]{b,c});
            // list[b].add(new int[]{a,c});
        }
        st = new StringTokenizer(reader.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        dist[a] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        int[] route = new int[n+1];

        pq.add(new int[]{a,0});

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(visited[now[0]]){
                continue;
            }
            visited[now[0]] = true;
            for (int[] next: list[now[0]]) {
                if(dist[next[0]] > now[1] + next[1]){
                    dist[next[0]] = now[1] + next[1];
                    route[next[0]] = now[0];
                    pq.add(new int[]{next[0], dist[next[0]]});
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        find(route, b, ans);
        StringBuilder sb = new StringBuilder();
        sb.append(dist[b])
        .append("\n");
        sb.append(ans.size())
        .append("\n");
        for (int i = ans.size()-1; i >= 0; i--) {
            sb.append(ans.get(i)).append(" ");
        }
        System.out.println(sb.toString());
        // System.out.println(Arrays.toString(dist));
        
    }
    static void find(int[] route,int end,List<Integer>list){
        if(end == 0){
            return;
        }
        list.add(end);
        find(route, route[end], list);
    }
}
