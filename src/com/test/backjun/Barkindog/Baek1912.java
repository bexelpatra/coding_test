package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1912 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
         
        Arrays.fill(dp, -1001);
        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            int now = arr[i];
            // now가 양수인지 음수인지가 핵심인듯...
            if(now > 0){
                dp[i] = Math.max(0,dp[i-1])+now;
            }else{
                dp[i] = Math.max(dp[i-1]+now,now);
            }

        }
        // System.out.println(Arrays.toString(dp));
        int max = -1001;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        System.out.println(max);
        
    }
}
