package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 0;
        dp[3] = 1;
        for (int i = 4; i < dp.length; i++) {
            dp[i] = dp[i-1] + 1 % 2;
        }
        if(n%2==0){
            System.out.println("SK");
            return;
        }
        System.out.println("CY");
        
    }
}
