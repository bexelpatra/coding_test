package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek17626 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = i;
            int sqrt = (int) Math.sqrt(i);
            for (int j = 1; j < sqrt + 1; j++) {
                dp[i] = Math.min(dp[i - j * j] + 1, dp[i]);
            }
        }
        System.out.println(dp[n]);
    }

}
