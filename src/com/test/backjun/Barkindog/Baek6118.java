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

public class Baek6118 {

    static List<Integer>[] list;
    static boolean[] visited;
    static int[] distance;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list= new List[n+1];
        visited = new boolean[n+1];
        distance = new int[n+1];
        Arrays.fill(distance, 100000000);
        distance[0]=0;
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        bfs(1);
        int maxDistance = -1;
        int location = 0;
        int totalcount = 0;
        for (int i = 1; i < distance.length; i++) {
            if(maxDistance < distance[i]){
                maxDistance = distance[i];
                location = i;
            }
        }
        for (int i = 1; i < distance.length; i++) {
            if(maxDistance == distance[i]){
                totalcount+=1;
            }
        }

        System.out.println(String.format("%d %d %d", location,maxDistance,totalcount));
    }

    static public void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        distance[start]=0;
        visited[start] = true;
        while(!q.isEmpty()){
            int now = q.poll();
            for (int i : list[now]) {
                if(visited[i]) continue;
                visited[i] = true;
                distance[i] = Math.min(distance[i], distance[now]+1);
                q.add(i);
            }
        }
    }
}
