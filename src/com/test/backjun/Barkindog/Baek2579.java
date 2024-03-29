package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2579 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        dp[1] = arr[1];
        if(n>1){
            dp[2] = dp[1] + arr[2];
            for (int i = 3; i < dp.length; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3] + arr[i-1]) + arr[i];
            }
        }

        System.out.println(dp[n]);

    }
}
