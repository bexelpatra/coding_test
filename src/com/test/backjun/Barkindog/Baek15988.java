package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek15988 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] dp = new long[1000000 + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        int[] arr = new int[n];
        int idx = 0;
        int max = 0;
        while(n-->0){
            int now = Integer.parseInt(reader.readLine());
            max=Math.max(max, now);
            arr[idx++] = now;
        }
        StringBuffer sb= new StringBuffer();
        for (int i = 4; i < max+1; i++) {
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            dp[i] %= 1000000009;
        }
        for (int i = 0; i < arr.length; i++) {
            sb.append(dp[arr[i]]).append("\n");
        }
        System.out.println(sb.toString());

    }

}
