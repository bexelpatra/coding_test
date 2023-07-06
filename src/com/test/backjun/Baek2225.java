package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2225 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // secondTry(reader);
        firstTry(reader);

    }

    private static void secondTry(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N + 1][K + 1];
        for (int i = 1; i < K + 1; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < N + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                dp[i][j] %= 1000000000;
            }
        }
        System.out.println(dp[N][K]);
    }

    private static void firstTry(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken()) + 1;
        int K = Integer.parseInt(st.nextToken());
        long[][] dp = new long[N + 1][K + 1];
        for (int i = 1; i < N + 1; i++) {
            dp[i][1] = 1;
        }

        for (int j = 1; j < K + 1; j++) {
            for (int i = 1; i < N + 1; i++) {
                int temp = i;
                while (temp >= 0) {
                    dp[i][j] += dp[temp][j - 1];
                    temp -= 1;
                }
                dp[i][j] %= 1000000000;
            }
            print(dp);
            System.out.println();
        }
        System.out.println(dp[N][K]);
    }

    private static void print(long[][] list) {
        for (int i = 0; i < list.length; i++) {
            System.out.println(Arrays.toString(list[i]));
        }
    }
}
