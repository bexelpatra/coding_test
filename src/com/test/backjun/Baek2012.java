package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Baek2012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(reader.readLine()));
        }
        int idx = 1;
        long result = 0;
        while (!pq.isEmpty()) {
            result += Math.abs(pq.poll() - idx++);
        }
        System.out.println(result);
        // getResultBySort(reader);
    }

    private static void getResultBySort(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] expect = new int[n + 1];
        for (int i = 1; i < expect.length; i++) {
            expect[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(expect);
        long result = 0;
        for (int i = 0; i < expect.length; i++) {
            int now = expect[i] - i;
            now = now < 0 ? now * -1 : now;
            result += now;
        }
        System.out.println(result);
    }
}
