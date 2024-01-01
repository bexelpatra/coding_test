package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek1715 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            pq.add(now);
        }
        if(n==1){
            System.out.println(0);
            return;
        }
        long sum = 0;
        while(n-->1){
            int now = pq.poll();
            int next = pq.poll();
            pq.add(now + next);
            sum += now + next;
        }
        
        System.out.println(sum);
    }
}
