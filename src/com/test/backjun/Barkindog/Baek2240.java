package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 1. 구현에서 막혔다.
 2. 꼭 다시한번 더 풀어보자
 */
public class Baek2240 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] one = new int[n+1][m+2];
        int[][] two = new int[n+1][m+2];

        for (int i = 1; i < n+1; i++) {
            int now = Integer.parseInt(reader.readLine());
            for (int j = 1; j < m+2; j++) {
                if(now == 1){
                    one[i][j] = Math.max(one[i-1][j], two[i-1][j-1])+1;
                    two[i][j] = Math.max(one[i-1][j-1], two[i-1][j]);
                }else{
                    // if (i == 1 && j == 1) continue;
                    one[i][j] = Math.max(one[i-1][j], two[i-1][j-1]);
                    two[i][j] = Math.max(one[i-1][j-1], two[i-1][j]) +1;
    
                }
            }
        }
        int result = 0;
        for (int i = 1; i < m+2; i++) {
            int now = Math.max(one[n][i], two[n][i]);
            result= Math.max(result, now);
        }
        System.out.println(result);
    }
}
