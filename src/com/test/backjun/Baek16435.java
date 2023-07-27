package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 스네이크버드
public class Baek16435 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int snake = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] <= snake) {
                snake += 1;
            } else {
                break;
            }
        }
        System.out.println(snake);
        // getPq(reader, n, snake);
    }

    private static void getPq(BufferedReader reader, int n, int snake) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(reader.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            pq.add(now);
        }
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (now <= snake) {
                snake += 1;
            } else {
                break;
            }
        }
        System.out.println(snake);
    }
}