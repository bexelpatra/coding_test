package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Baek11286 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        // PriorityQueue<int[]> pq = new PriorityQueue<>(new myCom());
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        });
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            if (now == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                    sb.append(System.lineSeparator());
                } else {
                    int[] temp = pq.poll();
                    sb.append(temp[0] * temp[1]);
                    sb.append(System.lineSeparator());
                }
            } else {
                int sign = now > 0 ? 1 : -1;
                int[] temp = new int[] { now * sign, sign };
                pq.add(temp);
            }
        }
        System.out.println(sb.toString());
    }

    static class myCom implements Comparator<int[]> {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            } else {
                return o1[0] - o2[0];
            }
        }
    }
}
