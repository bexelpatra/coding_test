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

public class Baek11725 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] parent = new int[n+1];
        boolean[] visited = new boolean[n+1];
        StringTokenizer st;
        List<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visited[1] = true;
        while(!q.isEmpty()){
            int papa = q.poll();
            for (Integer child : list[papa]) {
                if(!visited[child]){
                    visited[child] = true;
                    parent[child] = papa;
                    q.add(child);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < parent.length; i++) {
            sb.append(parent[i]).append("\n");
        }
        System.out.println(sb.toString());
        // System.out.println(Arrays.toString(parent));
    }
}
