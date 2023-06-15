package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1699_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // sol_2023_06_14_try_1(reader);
        sol_2023_06_14_try_2(reader);

    }

    private static void sol_2023_06_14_try_2(BufferedReader reader) throws Exception {
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                if (dp[i] > dp[i - j * j] + 1)
                    dp[i] = dp[i - j * j] + 1;
            }
        }
        System.out.println(dp[n]);
    }

    // 2023-06-14 failed...
    // exception -> 753 (my result: 4, answer : 3)
    private static void sol_2023_06_14_try_1(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());

        int[] dp = new int[n + 1];

        int square = 1;
        while (square * square <= n) {
            dp[square * square] = 1;
            square += 1;
        }
        for (int i = 2; i < dp.length; i++) {
            if (dp[i] == 1)
                continue;
            int root = root(i);
            dp[i] = dp[i - root * root] + 1;
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n]);
    }

    public static int root(int n) {
        int square = 1;
        while (square * square <= n) {
            square += 1;
        }
        return square - 1;
    }
}