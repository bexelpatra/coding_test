package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek15903 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>(Long::compareTo);
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < loop; i++) {
            long sum =pq.poll() + pq.poll();
            pq.add(sum);
            pq.add(sum);
        }
        long total = pq.stream().mapToLong(integer -> integer).sum();
        System.out.println(total);
    }
}
