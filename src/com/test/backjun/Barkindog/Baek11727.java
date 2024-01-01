package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11727 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i < n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2] *2) %10007;
        }
        System.out.println(dp[n]);

    }
}
