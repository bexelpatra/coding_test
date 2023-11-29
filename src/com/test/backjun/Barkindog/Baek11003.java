package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek11003{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Deque<int[]> dq = new ArrayDeque<>();
        st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] now = new int[]{Integer.parseInt(st.nextToken()),i};
            while(!dq.isEmpty() && dq.peekLast()[0]> now[0]){
                dq.pollLast();
            }
            dq.add(now);
            if(i - dq.peek()[1] >= m ) {
                dq.pollFirst();
            }
            sb.append(dq.peekFirst()[0]).append(" ");
        }
        System.out.println(sb.toString());
        // getSb(reader);

    }

    // 시간 초과...
    private static void getSb(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0]-o2[0];
        });
        // int[] result = new int[n];
        st = new StringTokenizer(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int[] now = new int[]{Integer.parseInt(st.nextToken()),i};
            pq.add(now);
            while(i - pq.peek()[1]>=m){
                pq.poll();
            }
            // result[i] = pq.peek()[0];
            sb.append(pq.peek()[0]).append(" ");
        }
        // System.out.println(Arrays.toString(result));
        System.out.println(sb.toString());
    }
}