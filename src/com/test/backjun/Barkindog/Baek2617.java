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

public class Baek2617 {

    static List<Integer>[] heavierList;
    static List<Integer>[] lighterList;
    static int[] bigger;
    static int[] smaller;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int len = n+1;
        heavierList = new List[len];
        lighterList = new List[len];
        visited = new boolean[len];
        for (int i = 0; i < len; i++) {
            heavierList[i] = new ArrayList<>();
            lighterList[i] = new ArrayList<>();
        }
        
        bigger = new int[len];
        smaller = new int[len];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            heavierList[b].add(a); // b보다 무거운 것에 a가 있다.
            lighterList[a].add(b); // a보다 가벼운것에 b가 있다.

        }

        for (int i = 1; i < len; i++) {
            bfs_bigger(i);
            bfs_smaller(i);
        }
        int half = n/2;
        int count =0 ;
        for (int i = 1; i < len; i++) {
            if(bigger[i] >= half || smaller[i] >= half){
                count+=1;
            }
        }
        // System.out.println(Arrays.toString(bigger));
        // System.out.println(Arrays.toString(smaller));
        System.out.println(count);
    }
    static boolean[] visited;
    static void bfs_bigger(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Arrays.fill(visited, false);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < heavierList[now].size(); i++) {
                int next = heavierList[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
                bigger[start]+=1;
            }
        }
    }
    static void bfs_smaller(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        Arrays.fill(visited, false);
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i = 0; i < lighterList[now].size(); i++) {
                int next = lighterList[now].get(i);
                if(visited[next]) continue;
                visited[next] = true;
                q.add(next);
                smaller[start]+=1;
            }
        }
    }
}
