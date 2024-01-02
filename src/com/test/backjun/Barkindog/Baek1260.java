package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1260 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        list = new List[n+1];
        
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        for (List<Integer> arr : list) {
            Collections.sort(arr);
        }
        dfs(start);
        sb.append("\n");
        Arrays.fill(visited, false);
        bfs(start);
        
        System.out.println(sb.toString());

    }

    static List<Integer>[] list;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void bfs(int n){
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            sb.append(now).append(" ");
            for (Integer next : list[now]) {
                if(!visited[next]){
                    visited[next] =true;
                    q.add(next);
                }
            }
        }
    }
    static void dfs(int n){
        if(!visited[n]){
            sb.append(n).append(" ");
            visited[n] = true;
            for (int next : list[n]) {
                dfs(next);
            }
        }

    }
}
