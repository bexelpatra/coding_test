package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 보물섬
public class Baek2589 {

    static int Y, X;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        char[][] map = new char[Y][];
        for (int i = 0; i < Y; i++) {
            map[i] = reader.readLine().toCharArray();
        }
        for (int i = 0; i < Y; i++) {
            for (int j = 0; j < X; j++) {
                if (map[i][j] == 'L') {
                    bfs(map, new boolean[Y][X], j, i);
                }
            }
        }
        // System.out.println(count);
        System.out.println(max);

    }

    static int max = -1;

    public static void bfs(char[][] map, boolean[][] visited, int x, int y) {
        int[] ny = { 0, 0, 1, -1 };
        int[] nx = { 1, -1, 0, 0 };
        // PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
        // return o2[2] - o1[2];
        // });
        Queue<int[]> pq = new LinkedList<>();
        visited[y][x] = true;
        pq.add(new int[] { y, x, 0 });
        int maxTemp = -1;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            maxTemp = Math.max(maxTemp, now[2]);
            for (int i = 0; i < ny.length; i++) {
                int nextY = ny[i] + now[0];
                int nextX = nx[i] + now[1];
                if (inArea(nextY, nextX)) {
                    if (map[nextY][nextX] == 'L' && !visited[nextY][nextX]) {
                        visited[nextY][nextX] = true;
                        pq.add(new int[] { nextY, nextX, now[2] + 1 });
                    }
                }
            }
        }
        System.out.println(String.format("y: %d x: %d distance : %d", y, x, maxTemp));
        max = Math.max(maxTemp, max);
    }

    public static boolean inArea(int y, int x) {
        if (x < 0 || y < 0 || X - 1 < x || Y - 1 < y) {
            return false;
        }
        return true;
    }
}
