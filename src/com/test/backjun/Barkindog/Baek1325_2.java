package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1325_2 {
    static int n,m;
    static List<Integer>[] list;
    static boolean[] visited;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n+1];
        count = new int[n+1];
        list = new List[n+1];

        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        for (int i = 1; i < list.length; i++) {
            Arrays.fill(visited, false);
            bfs(i);
        }

        int max = -1;
        List<Integer> result= new ArrayList<>();
        for (int i = 0; i < count.length; i++) {
            if(max > count[i]) continue;
            else if(max == count[i]) result.add(i);
            else if(max < count[i]){
                max = count[i];
                result.clear();
                result.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        result.forEach(t -> sb.append(t).append(" "));
        System.out.println(sb.toString());

    }
    static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i : list[now]) {
                if(!visited[i]){
                    count[i]+=1;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }

    static void dfs(int start){
        visited[start] = true;
        for (int i : list[start]) {
            if(visited[i]) continue;
            count[i] +=1;
            dfs(i);
        }
    }
}
