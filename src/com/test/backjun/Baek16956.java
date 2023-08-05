package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek16956 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] map = new char[y][x];

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < map.length; i++) {
            String line = reader.readLine();
            for (int j = 0; j < line.length(); j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'S') {
                    q.add(new int[] { i, j });
                } else if (map[i][j] == '.') {
                    map[i][j] = 'D';
                }
            }
        }

        while (!q.isEmpty()) {
            int[] now = q.poll();
            if (!defence(map, now[0], now[1])) {
                System.out.println(0);
                return;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(1).append(System.lineSeparator());
        for (int i = 0; i < map.length; i++) {
            sb.append(new String(map[i])).append(System.lineSeparator());
        }
        System.out.println(sb.toString());

    }

    public static boolean defence(char[][] map, int nowY, int nowX) {
        int y = map.length;
        int x = map[nowY].length;
        int[] dy = { 0, 0, 1, -1 };
        int[] dx = { 1, -1, 0, 0 };
        for (int i = 0; i < 4; i++) {
            int nextY = nowY + dy[i];
            int nextX = nowX + dx[i];
            if (nextY <= y - 1 && nextX <= x - 1 && nextX >= 0 && nextY >= 0) {
                char c = map[nextY][nextX];
                if (c == 'W') {
                    return false;
                }
                // else {
                // map[nextY][nextX] = 'D';
                // }
                // else if (c == '.') {
                // map[nextY][nextX] = 'D';
                // }
            }
        }
        return true;
    }
}
