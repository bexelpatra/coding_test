package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 나중에 재시도 하자...
public class Baek1781 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }
            return o2[1] - o1[1];
        });
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int a= Integer.parseInt(st.nextToken());
            int b= Integer.parseInt(st.nextToken());
            pq.add(new int[]{a,b});

        }
        long sum =0 ;
        int count = 0;
        int limit = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0] > limit){
                limit = now[0];
            }
            if(count < limit){
                sum+=now[1];
                count+=1;
            }
        }
        System.out.println(sum);
    }
}
