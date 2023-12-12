package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1149 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int THREE = 3;
        int[][] map = new int[n][THREE];
        StringTokenizer st = null;
        int[][] dp = new int[n][THREE];
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(reader.readLine());
            for (int j = 0; j < THREE; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < THREE; i++) {
            dp[0][i] = map[0][i];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < THREE; j++) {
                dp[i][j] = Math.min(dp[i-1][(j+1)%THREE], dp[i-1][(j+2)%THREE]) + map[i][j];
            }
        }
        
        // for (int[] is : dp) {
        //     System.out.println(Arrays.toString(is));
        // }
        int min = 1000 * 1000 +1;
        for (int i = 0; i < THREE; i++) {
            min = Math.min(min,dp[n-1][i]);
        }
        System.out.println(min);
    }
}
