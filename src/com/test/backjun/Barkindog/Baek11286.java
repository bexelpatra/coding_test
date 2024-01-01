package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek11286 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if(o1[1] == o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1]-o2[1];
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            int sign =1;
            if(now!=0){
                if(now <0){
                    now *=-1;
                    sign *=-1;
                }
                pq.add(new int[]{sign,now});
            }else{
                int[] num = pq.poll();
                if(num == null){
                    sb.append(0).append("\n");
                }else{
                    sb.append(num[0]*num[1]).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
