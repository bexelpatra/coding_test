package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 전체 탐색?
public class Baek11724 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[n+1];
        boolean[] visited = new boolean[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
            list[to].add(from);
        }
        int count =0;
        for (int i = 1; i < n+1; i++) {
            if(!visited[i]){
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                visited[i] = true;
                while(!q.isEmpty()){
                    int now = q.poll();
                    for (Integer next : list[now]) {
                        if(!visited[next]){
                            visited[next ] = true;
                            q.add(next);
                        }
                    }
                }
                count+=1;
            }
        }
        System.out.println(count);
    }
}
