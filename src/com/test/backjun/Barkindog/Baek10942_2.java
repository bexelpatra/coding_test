package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10942_2 {
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }  

        boolean[][] dp = new boolean[n+1][n+1];
        for (int i = 1; i < n+1; i++) {
            dp[i][i]=true;
        }
        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i+1]){
                dp[i][i+1] = true;
            }
        }
        // 길이에 따른 펠린드럼 확인
        for (int i = 2; i < n; i++) { // 확인할 길이
            for (int j = 1; j < n + 1 -i; j++) { // 시작점
                // System.out.printf("i : %d j : %d , start : %d end : %d\n",i,j,j,j+i);
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1]){
                    dp[j][j+i]= true;   
                }
            }
        }

        for (boolean[] bs : dp) {
            // System.out.println(Arrays.toString(bs));
        }
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(dp[start][end]?1:0)
            .append("\n");
            
        }
        System.out.println(sb.toString());

    }
}
