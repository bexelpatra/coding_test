package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 과제
public class Baek13904 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] pjt = new int[n][2];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            pjt[i][0] = Integer.parseInt(st.nextToken());
            pjt[i][1] = Integer.parseInt(st.nextToken());
        }

        Comparator<int[]> A = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o2[1] - o1[1];
                } else {
                    return o1[0] - o2[0];
                }
            }
        };
        Comparator<int[]> B = new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[1] == b[1]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            }
        };

        Arrays.sort(pjt, A);

        // for (int[] is : pjt) {
        // System.out.println(Arrays.toString(is));
        // }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.naturalOrder());
        for (int i = 0; i < pjt.length; i++) {
            int[] now = pjt[i];
            if (pq.size() < now[0]) {
                pq.add(now[1]);
            } else if (pq.size() == now[0] && !pq.isEmpty()) {
                int check = pq.peek();
                if (check < now[1]) {
                    pq.poll();
                    pq.add(now[1]);
                }
            }
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }

}
