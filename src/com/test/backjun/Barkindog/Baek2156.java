package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    1. n 번째 것을 뽑는것이 아니므로 그 이전의 숫자가 그냥 더욱 클수도 있다.
    2. dp 저장시 해당 내용도 저장을 해줘야 한다.
 */
public class Baek2156 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr= new int[n+1];
        int[] dp = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        dp[1] = arr[1];
        if(n>1){
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i < n+1; i++) {
                dp[i] = Math.max(dp[i-2], dp[i-3]+arr[i-1]) +  arr[i];
                dp[i] = Math.max(dp[i], dp[i-1]);
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        // System.out.println(Arrays.toString(dp));
        
        System.out.println(max);

        
    }
}
