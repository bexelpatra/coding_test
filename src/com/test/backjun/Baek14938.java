package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek14938 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        int[] items = new int[v+1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < items.length; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        List<int[]>[] list = new List[v+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
    
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            
            list[from].add(new int[]{to,val});
            list[to].add(new int[]{from,val});
        }
        int max = 0;
        for (int i = 1; i < v+1; i++) {
            int total = getTotal(v, target, items, list, i);
            max = Math.max(total, max);
        }
        System.out.println(max);
    }

    private static int getTotal(int v, int target, int[] items, List<int[]>[] list, int start) {
        int[] dist  = new int[v+1];
        boolean[] visited = new boolean[v+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        Arrays.fill(visited,false);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{start,0});
        dist[start] = 0;

        while(!pq.isEmpty()){
            int[] now = pq.poll();
            int pos = now[0];

            if(!visited[pos]){
                visited[pos] = true;
                // list[pos].forEach(position ->{
                //     if(!visited[position[0]] && dist[position[0]] > dist[pos] + position[1]){
                //         visited[position[0]] = true; // 아직 방문한 것이아니기 때문에 여기서 값을 변경하면 안된다...
                //         dist[position[0]] = dist[pos] + position[1];
                //         pq.add(new int[]{position[0],dist[position[0]]});
                //     }
                // } );
                for (int[] position : list[pos]) {
                    int posNum = position[0];
                    int weight = position[1];
                    
                    if(!visited[posNum] && dist[posNum] > dist[pos] + weight){
                        dist[posNum] = dist[pos] + weight;
                        pq.add(new int[]{posNum,dist[posNum]});
                    }
                }
            }
        }
        int total =0;
        for (int j = 1; j < dist.length; j++) {
            if(dist[j]<= target){
                total += items[j];
            }
        }
        return total;
    }
}
