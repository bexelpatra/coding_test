package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek9655 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        for (int i = 4; i < n + 1; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 3]) + 1;
        }

        System.out.println(Arrays.toString(dp));
        // sol1(n);
    }

    private static void sol1(int n) {
        if (n % 2 == 0) {
            System.out.println("CY");
        } else {
            System.out.println("SK");

        }
    }
}
