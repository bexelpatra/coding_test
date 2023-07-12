package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek2583 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[y][x];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for (int yPoint = y1; yPoint < y2; yPoint++) {
                for (int xPoint = x1; xPoint < x2; xPoint++) {
                    map[yPoint][xPoint] = true;
                }
            }
        }

        Deque<int[]> dq = new ArrayDeque<>();
        int[] moveY = { 1, -1, 0, 0 };
        int[] moveX = { 0, 0, 1, -1 };
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (!map[i][j]) {
                    int square = 1;
                    map[i][j] = true;
                    dq.add(new int[] { i, j });
                    while (!dq.isEmpty()) {
                        int[] now = dq.pop();
                        for (int k = 0; k < 4; k++) {
                            int nextY = now[0] + moveY[k];
                            int nextX = now[1] + moveX[k];
                            if (nextX >= 0 && nextY >= 0 && nextY < y && nextX < x && !map[nextY][nextX]) {
                                map[nextY][nextX] = true;
                                dq.add(new int[] { nextY, nextX });
                                square += 1;
                            }
                        }
                    }
                    count += 1;
                    pq.add(square);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(count);
        sb.append(System.lineSeparator());
        while (!pq.isEmpty()) {
            sb.append(pq.poll());
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
