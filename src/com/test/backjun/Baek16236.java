package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek16236 {
    static int move = Integer.MAX_VALUE;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        int[] shark = new int[2];
        int fishCount = 0;
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int now = Integer.parseInt(st.nextToken());
                map[i][j] = now;
                if (now == 9) {
                    shark[0] = i;
                    shark[1] = j;
                    now = 0;
                } else if (now != 0) {
                    fishCount += 1;
                }
            }
        }
        dfs(map, new boolean[map.length][map.length], shark[0], shark[1], shark[0], shark[1], 2, 0, fishCount, 0, "");
        System.out.println(move);
        System.out.println(sb.toString());
    }

    static StringBuilder sb = new StringBuilder();

    public static void dfs(int[][] map, boolean[][] visited, int nowX, int nowY, int lastX, int lastY, int sharkSize,
            int levelUp, int fishCount, Integer moeveCount, String c8) {
        if (fishCount == 0) {

            // sb.append(String.format("nowx : %d, nowy : %d, lastX : %d, lastY : %d ,
            // fishCount : %d, move :%d\n", nowX,
            // nowY, lastX, lastY, fishCount, move));
            sb.append(c8);
            sb.append(System.lineSeparator());
            move = Math.min(move, moeveCount);
            return;
        }
        if (levelUp == sharkSize) {
            levelUp = 0;
            sharkSize += 1;
        }

        int[] x = { 0, 0, 1, -1 };
        int[] y = { 1, -1, 0, 0 };
        int nextX = 0;
        int nextY = 0;
        for (int i = 0; i < y.length; i++) {
            nextY = nowY + y[i];
            nextX = nowX + x[i];
            if (valid(map, map.length, nextX, nextY, sharkSize)) {
                int fish = map[nextY][nextX];
                if (fish - sharkSize == 0) { // 못잡아먹음
                    dfs(map, visited, nextX, nextY, nowX, nowY, sharkSize, levelUp, fishCount, moeveCount + 1,
                            String.format("%s-> [%d,%d]", c8, nextX, nextY));
                } else if (fish == 0 && !visited[nextY][nextX]) { // 빈칸...
                    visited[nextY][nextX] = true;
                    dfs(map, visited, nextX, nextY, nowX, nowY, sharkSize, levelUp, fishCount, moeveCount + 1,
                            String.format("%s-> [%d,%d]", c8, nextX, nextY));
                } else if (fish - sharkSize < 0) { // 잡아먹음
                    visited[nextY][nextX] = true;
                    dfs(map, visited, nextX, nextY, nowX, nowY, sharkSize, levelUp + 1, fishCount - 1, moeveCount + 1,
                            String.format("%s-> [%d,%d]", c8, nextX, nextY));
                }
            }

        }
    }

    public static boolean valid(int[][] map, int n, int nextX, int nextY, int sharkSize) {
        if (nextX < 0 || nextY < 0 || nextX > n - 1 || nextY > n - 1) {
            return false;
        }
        if (map[nextY][nextX] > sharkSize) {
            return false;
        }
        return true;
    }
}
