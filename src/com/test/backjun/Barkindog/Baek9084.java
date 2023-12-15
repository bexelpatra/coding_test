package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek9084 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringTokenizer st ;
        StringBuffer sb = new StringBuffer();
        while(loop-->0){
            int n = Integer.parseInt(reader.readLine());
            st = new StringTokenizer(reader.readLine());
            int target = Integer.parseInt(reader.readLine());

            int[] arr = new int[n];
            int[] dp = new int[target+1];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            dp[0] = 1;
            // 반복문의 순서를 바꾸면 결과가 많이 달라진다. 왜 그런거지???
            for (int coin : arr) {
                for (int i = 1; i < dp.length; i++) {
                    int now = i - coin;
                    if(now <0) continue;
                    dp[i] += dp[now];
                }
                System.out.println(Arrays.toString(dp));
            }
            // sb.append(Arrays.toString(dp)).append("\n");
         
        }
        System.out.println(sb.toString());
    }   
}
