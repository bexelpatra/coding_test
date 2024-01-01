package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek9461 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;
        dp[4] = 2;
        for (int i = 5; i < dp.length; i++) {
            dp[i] = dp[i-1] + dp[i-5];
        }
        // System.out.println(Arrays.toString(dp));
        StringBuilder sb = new StringBuilder();
        while(loop-->0){
            sb.append(dp[Integer.parseInt(reader.readLine())]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
