package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 경로찾기
// Floyd Warshal algorithm이라고 한다.
public class Baek11403 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        StringTokenizer st = null;
        for (int y = 0; y < map.length; y++) {
            st = new StringTokenizer(reader.readLine());
            for (int x = 0; x < map[y].length; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for (int layOver = 0; layOver < n; layOver++) {
            for (int from = 0; from < map.length; from++) {
                for (int to = 0; to < map[from].length; to++) {
                    if (map[from][layOver] == 1 && map[layOver][to] == 1) {
                        map[from][to] = 1;
                    }
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        // for (int i = 0; i < n * n; i++) {
        // int from = i / n;
        // int to = i % n;
        // sb.append(map[from][to]);
        // sb.append(' ');
        // if (i % n == n - 1) {
        // sb.append(System.lineSeparator());
        // }
        // }
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                sb.append(map[i][j]);
                sb.append(' ');
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
