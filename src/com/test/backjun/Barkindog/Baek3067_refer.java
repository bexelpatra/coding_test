package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
 
 
//https://dingdingmin-back-end-developer.tistory.com/entry/%EB%B0%B1%EC%A4%80-3067%EC%9E%90%EB%B0%94-java-Coins
public class Baek3067_refer {
 
    static int t,n;
    static int target;
    static int[] arr;
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            n = Integer.parseInt(br.readLine());
            arr = new int[n+1];
            dp = new int[n+1][10001];
            String[] s = br.readLine().split(" ");
            for(int j=1; j<=n; j++){
                arr[j] = Integer.parseInt(s[j-1]);
                dp[j][Integer.parseInt(s[j-1])]++;
            }
            target = Integer.parseInt(br.readLine());
 
            makeAnswer();
 
            sb.append(dp[n][target]).append("\n");
        }
        System.out.println(sb.toString());
    }
 
    private static void makeAnswer() {
        for(int j=1; j<=n; j++){
            for(int q=1; q<=target; q++){
                System.out.println(Arrays.toString(dp[j]));
                if(q-arr[j]<0){
                    dp[j][q]=dp[j-1][q];
                    continue;
                }
                dp[j][q] += dp[j-1][q]+dp[j][q-arr[j]];
            }
        }
    }
}