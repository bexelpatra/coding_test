package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11055 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = arr[0];
        for (int i = 0; i < n; i++) {
            dp[i] = arr[i]; // 반드시 초기값을 설정을 잘 해줘야만 한다.
            for (int j = 0; j < i; j++) {
                if(dp[i] < dp[j]+arr[i] && arr[j] < arr[i]){
                    dp[i] = dp[j]+ arr[i];
                    // System.out.println(Arrays.toString(dp));
                    max = Math.max(max, dp[i]);
                }
            }
        }
        System.out.println(max);
    }
}
