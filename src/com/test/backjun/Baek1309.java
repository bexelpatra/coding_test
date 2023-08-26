package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//https://steady-coding.tistory.com/156
public class Baek1309 {
    public static int[][] map = new int[4][2];
    public static StringBuilder[] sbs = new StringBuilder[map.length];

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = i * 2;
            dp[i][i] = 2;
        }
        for (int i = 2; i < dp.length; i++) {
            for (int j = 2; j < i; j++) {
                dp[i][j] = (dp[i - 1][j - 1] - 1) * 2 + dp[i - 1][j];
                System.out.printf("dp[%d][%d] = %d\n", i, j, dp[i][j]);
            }
            // System.out.println(Arrays.stream(dp[i]).sum());
            print(dp);
        }

        // for (int i = 0; i < sbs.length; i++) {
        // sbs[i] = new StringBuilder();
        // }
        // for (int i = 1; i < 5; i++) { // 1 ~ 4개를 뽑아보자
        // recur(map, new boolean[4][2], i, 0, 0);
        // }

    }

    // 점화식 i 줄에서 j개의 물건 넣음
    // dp[i][j] = (dp[i-1][j-1] -1) *2 + dp[i-1][j-1]
    public static void print(int[][] map) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void print(boolean[][] map) {
        for (int i = 0; i < map.length - 1; i++) {
            if (map[i][0] && map[i + 1][0]) {
                return;
            } else if (map[i][1] && map[i + 1][1]) {
                return;
            }
        }
        for (int i = 0; i < map.length; i++) {
            if (map[i][0] && map[i][1]) {
                return;
            }
        }
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            sb.append(map[i][0] ? 1 : 0).append(map[i][1] ? 1 : 0).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void recur(int[][] map, boolean[][] visit, int target, int count, int idx) {

        if (target == count) {
            print(visit);
            return;
        }
        for (int i = idx; i < map.length * map[0].length; i++) {
            int y = i / 2;
            int x = i % 2;
            if (!visit[y][x]) {
                visit[y][x] = true;
                recur(map, visit, target, count + 1, idx + 1);
                visit[y][x] = false;
            }
        }

    }
}
