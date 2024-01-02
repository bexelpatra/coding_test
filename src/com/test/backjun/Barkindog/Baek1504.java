package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a=  Integer.parseInt(st.nextToken());
            int b=  Integer.parseInt(st.nextToken());
            int c=  Integer.parseInt(st.nextToken());
            
            list[a].add(new int[]{b,c});
            list[b].add(new int[]{a,c});
        }
        int[] route = new int[4];
        st = new StringTokenizer(reader.readLine());
        route[0]=1;
        route[3]=n;
        for (int i = 1; i < 3; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }
        int max = Integer.MAX_VALUE;
        int sum =0;
        
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < route.length-1; j++) {
                int temp = dik(route[j], route[j+1]);
                if(temp == Integer.MAX_VALUE){
                    sum = temp;
                    break;
                }
                sum+= temp;
            }
            int temp = route[1];
            route[1] = route[2];
            route[2] = temp;
            max = Math.min(max, sum);
            sum=0;
        }
        max = max == Integer.MAX_VALUE ? -1: max;
        System.out.println(max);
    }
    static List<int[]>[] list ;
    public static int dik(int start, int end){
        int[] dist = new int[list.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        pq.add(new int[]{start,0});
        dist[start] = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            for (int[] next : list[now[0]]) {
                if(dist[next[0]] > now[1] + next[1]){
                    dist[next[0]] = now[1] + next[1];
                    pq.add(new int[]{next[0],dist[next[0]]});
                }
            }
        }
        return dist[end];
    }
}
