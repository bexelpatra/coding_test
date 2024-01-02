package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek1743 {
    static int y;
    static int x;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        map = new char[y + 1][x + 1];
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(reader.readLine());
            int gY = Integer.parseInt(st.nextToken());
            int gX = Integer.parseInt(st.nextToken());
            map[gY][gX] = '1';
        }

        boolean[][] visited = new boolean[y + 1][x + 1];
        int max = 0;
        for (int i = 1; i < y + 1; i++) {
            for (int j = 1; j < x + 1; j++) {
                if (map[i][j] == '1') {
                    // max = bfs(visited, max, i, j);
                    temp = 0;
                    visited[i][j] = true;
                    max(i, j, visited);
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);

    }

    private static int bfs(boolean[][] visited, int max, int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] { i, j });
        visited[i][j] = true;
        int temp = 0;
        while (!q.isEmpty()) {
            int[] now = q.poll();
            temp += 1;
            for (int k = 0; k < 4; k++) {
                int nextY = now[0] + goY[k];
                int nextX = now[1] + goX[k];
                if (nextY <= 0 || nextX <= 0 || nextY > y || nextX > x)
                    continue;
                if (!visited[nextY][nextX] && map[nextY][nextX] == '1') {
                    visited[nextY][nextX] = true;
                    q.add(new int[] { nextY, nextX });
                }
            }
        }
        max = Math.max(max, temp);
        return max;
    }

    static int[] goY = { 0, 0, 1, -1 };
    static int[] goX = { 1, -1, 0, 0 };

    static int temp = 0;

    public static void max(int ny, int nx, boolean[][] visited) {
        temp += 1;
        for (int i = 0; i < 4; i++) {
            int nextY = ny + goY[i];
            int nextX = nx + goX[i];
            if (nextY > y || nextX > x || nextX <= 0 || nextY <= 0) {
                continue;
            }
            if (!visited[nextY][nextX] && map[nextY][nextX] == '1') {
                visited[nextY][nextX] = true;
                max(nextY, nextX, visited);
            }
        }
    }
}
