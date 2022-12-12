package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek2212 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        sol1(reader);
        sol2(reader);
    }

    //https://www.acmicpc.net/source/52506200
    private static void sol2(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        if (n<=k){
            System.out.println(0);
            return;
        }

        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sensors);
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int i = 0; i < n-1; i++) {
            pq.add(sensors[i+1]-sensors[i]);
        }
        for (int i = 0; i < k-1; i++) {
            pq.poll();
        }
        long ans = pq.stream().mapToLong(integer -> integer).sum();
        System.out.println(ans);
    }

    private static void sol1(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int k = Integer.parseInt(reader.readLine());
        if (n<=k){
            System.out.println(0);
            return;
        }

        int[] sensors = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(sensors);
        int[] diff = new int[n];
        for (int i = 0; i < n-1; i++) {
            diff[i] = sensors[i+1] - sensors[i];
        }
        Arrays.sort(diff);
        long ans = 0;
        for (int i = n-1 -(k-1); i >= 0; i--) {
            ans +=diff[i];
        }
        System.out.println(ans);
    }
}
