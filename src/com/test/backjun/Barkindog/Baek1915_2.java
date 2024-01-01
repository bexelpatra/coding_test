package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 넓이를 구하는 방식
 * 생각보다 느리다...
 */
public class Baek1915_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        char[][] map = new char[y+1][x+1];
        int[][] dp = new int[y+1][x+1];

        for (int i = 1; i < y+1; i++) {
            char[] arr = reader.readLine().toCharArray();
            for (int j = 1; j < x+1; j++) {
                map[i][j] = arr[j-1];
                dp[i][j] = dp[i][j-1] + (map[i][j]-'0');
            }
        }
        for (int i = 1; i < y+1; i++) {
            for (int j = 1; j < x+1; j++) {
                dp[i][j] += dp[i-1][j] ;
            }
        }
        int max = 0;
        for (int i = 1; i < y+1; i++) {
            for (int j = 1; j < x+1; j++) {
                if(map[i][j]=='1'){
                    int len = 1;
                    int size = 1;
                    int temp = 1;
                    while(i+len <y+1 && j+len < x+1){
                        size = dp[i+len][j+len] + dp[i][j] - dp[i-1][j+len] - dp[i+len][j-1];
                        len +=1;
                        if(size != len * len){
                            break;
                        }
                        temp = len *len;
                    }
                    max = Math.max(max, temp);
                }
            }
        }
        System.out.println(max);


    }
}
