package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1261 implements BaekImpl<String> {

    static int[] nextY = new int[] { 0, 0, 1, -1 };
    static int[] nextX = new int[] { 1, -1, 0, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        if (x * y == 1) {
            System.out.println(0);
            return;
        }
        char[][] map = new char[y][x];
        boolean[][] visited = new boolean[y][x];
        int[][] count = new int[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = reader.readLine().toCharArray();
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + nextY[i];
                int nx = now[1] + nextX[i];
                if (ny < 0 || nx < 0 || ny >= y || nx >= x) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] == '0') {
                        count[ny][nx] = Math.min(now[2], count[ny][nx]);
                    } else {
                        count[ny][nx] = Math.min(now[2] + 1, count[ny][nx]);
                    }
                    pq.add(new int[] { ny, nx, count[ny][nx] });
                }
            }
        }

        System.out.println(count[y - 1][x - 1]);
    }

    @Override
    public String getResult(BufferedReader reader) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];
        boolean[][] visited = new boolean[y][x];
        int[][] count = new int[y][x];

        for (int i = 0; i < y; i++) {
            map[i] = reader.readLine().toCharArray();
            Arrays.fill(count[i], Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        pq.add(new int[] { 0, 0, 0 });

        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now[0] + nextY[i];
                int nx = now[1] + nextX[i];
                if (ny < 0 || nx < 0 || ny >= y || nx >= x) {
                    continue;
                }

                if (!visited[ny][nx]) {
                    visited[ny][nx] = true;
                    if (map[ny][nx] == '0') {
                        count[ny][nx] = Math.min(now[2], count[ny][nx]);
                    } else {
                        count[ny][nx] = Math.min(now[2] + 1, count[ny][nx]);
                    }
                    pq.add(new int[] { ny, nx, count[ny][nx] });
                }
            }
        }
        // System.out.println(count[y - 1][x - 1]);
        return String.valueOf(count[y - 1][x - 1]);
    }
}
