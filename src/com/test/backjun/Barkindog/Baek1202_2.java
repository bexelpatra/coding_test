package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baek1202_2 {
    static PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        return o2[1] - o1[1];
    });
    static TreeMap<Integer,Integer> bags = new TreeMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            pq.add(new int[]{w,v});
        }
        for (int i = 0; i < m; i++) {
            int w = Integer.parseInt(reader.readLine());
            int cnt = bags.getOrDefault(w, 0);
            bags.put(w, cnt+1);
        }

        long sum =0 ;
        do{
            int[] now = pq.poll();
            Integer w = bags.ceilingKey(now[0]);
            if(w==null) continue;
            sum += now[1];
            int cnt = bags.get(w);
            if(cnt==1) {
                bags.remove(w);
            }else {
                bags.put(w, cnt-1);
            }
        }while(!pq.isEmpty());
        System.out.println(sum);

    }
}
