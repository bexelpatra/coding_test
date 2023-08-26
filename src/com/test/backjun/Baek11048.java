package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11048 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + map[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + map[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j][i] = Math.max(dp[j - 1][i], dp[j][i - 1]) + map[j][i];
            }
        }
        System.out.println(dp[n - 1][m - 1]);
        for (int i = 0; i < dp.length; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }
    }
}
