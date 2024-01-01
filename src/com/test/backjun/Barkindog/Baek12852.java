package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// 모든 것들의 경로에 대해서 파악하고 있으므로 비용이 너무 비싸다.
// 최적의 경로를 계산해서 잽싸게 끝낼 수 있도록 수정이 필요하다.
public class Baek12852 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        int[] dp = new int[n+3];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;
        
        int[][] chain = new int[dp.length][];
        
        chain[0] = new int[]{};
        chain[1] = new int[]{1};
        chain[2] = new int[]{2,1};
        chain[3] = new int[]{3,1};
        
        for (int i = 4; i < dp.length; i++) {
            int min = dp[i-1]+1;
            int type = 1;

            if(i%3==0){
                if(dp[i/3]+1 < min){
                    min = dp[i/3]+1;
                    type = 3;
                }
            }
            if(i%2==0){
                if(dp[i/2]+1 < min){
                    min = dp[i/2]+1;
                    type = 2;
                }
            }
            if(type==1){
                chain[i] = copy(i, chain[i-1]);
            }else{
                chain[i] = copy(i, chain[i/type]);
            }
            dp[i] = min;
        }
        sb.append(dp[n]).append("\n");
        for (int i : chain[n]) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }

    public static int[] copy(int n, int[] arr){
        int[] result= new int[arr.length+1];
        result[0] = n;
        for (int i = 1; i < result.length; i++) {
            result[i] = arr[i-1];
        }
        return result;
    }
}
