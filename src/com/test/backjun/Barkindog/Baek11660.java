package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11660 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());

        int len = Integer.parseInt(st.nextToken());
        int loop =  Integer.parseInt(st.nextToken());
        int[][] map = new int[len + 1][len +1];
        int[][] dp = new int[len + 1][len +1];

        // 표 받기
        for (int i = 1; i < len + 1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < len+1; j++) {
                // map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + Integer.parseInt(st.nextToken());
            }
        }
        // 좌표 받기
        int[][] point = new int[loop][4];
        for (int i = 0; i < point.length; i++) {
            st = new StringTokenizer(reader.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
            point[i][2] = Integer.parseInt(st.nextToken());
            point[i][3] = Integer.parseInt(st.nextToken());
        }

        // 합 구하기
        for (int i = 1; i < len + 1; i++) {
            for (int j = 1; j < len+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1] + map[i][j];
            }
        }
        // for (int[] is : dp) {
        //     System.out.println(Arrays.toString(is));
        // }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < point.length; i++) {
            int x1 = point[i][1];
            int y1 = point[i][0];
            
            int x2 = point[i][3];
            int y2 = point[i][2];

            int now = dp[y2][x2] + dp[y1-1][x1-1] - dp[y2][x1-1] - dp[y1-1][x2];
            sb.append(now).append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
