package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1417 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(n, Comparator.reverseOrder());
        int me = Integer.parseInt(reader.readLine());
        for (int i = 1; i < n; i++) {
            pq.add(Integer.parseInt(reader.readLine()));
        }
        int count = 0;
        while (!pq.isEmpty() && me <= pq.peek()) {
            int now = pq.poll();
            me += 1;
            pq.add(now - 1);
            count += 1;
        }
        System.out.println(count);

    }
}
