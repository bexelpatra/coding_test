package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        int[] dp = new int[m+1];
        Arrays.fill(dp, 100_000_000);
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(reader.readLine());
            arr[i] = temp;
            if(temp < m + 1){
                dp[temp] = 1;
            }
        }

        for (int i = 1; i < m+1; i++) {
            for (int coin : arr) {
                if(i - coin > 0){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }

        // System.out.println(Arrays.toString(dp));
        if(dp[m] == 100_000_000){
            dp[m] = -1;
        }
        System.out.println(dp[m]);
    }
}

