package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // getMySolution(reader);
        refer(reader);
    }

    private static void getMySolution(BufferedReader reader) throws IOException {
        String temp = reader.readLine();
        int[] arr = new int[temp.length()+1];
        for (int i = 1; i < arr.length; i++) {
            arr[i] = temp.charAt(i-1)-'0';
        }
        int[] dp = new int[arr.length+1];
        dp[0] = 1;
        dp[1] = 1;
        if(arr[1]==0){
            System.out.println(0);
            return;
        }
        for (int i = 2; i < arr.length; i++) {
            if(arr[i-1] ==1 && arr[i]!=0){
                dp[i] = dp[i-1]+ dp[i-2];
            }else if(arr[i-1] ==2 && arr[i] < 7 &&arr[i]!=0){
                dp[i] = dp[i-1] + dp[i-2];
            }else if(arr[i-1] == 0) {
                if(arr[i]==0){
                    System.out.println(0);
                    return;
                }
                dp[i] = dp[i-1];
            }else if(arr[i]==0){
                if(arr[i-1] ==1 || arr[i-1]==2){
                    dp[i] = dp[i-2];
                }else{
                    System.out.println(0);
                    return;
                }
            }else{
                dp[i] = dp[i-1];
            }
            dp[i] %=1000000;
            // System.out.printf("arr[%d] = %d, arr[%d] = %d\n",i-1,arr[i-1],i,arr[i]);
            // System.out.println(Arrays.toString(dp));
            
        }
        System.out.println(dp[arr.length-1]);
    }

    // https://www.acmicpc.net/source/7606219
    // 조건을 간소화해서 더욱 간단하다
    public static void refer(BufferedReader reader) throws IOException{
        String input = reader.readLine();
    	int[] dp = new int[input.length()+1];
    	int mod = 1000000;
    	int[] in = new int[input.length()+1];
    	
    	in[0] = 0;
    	for(int i=1; i<=input.length(); i++) {
    		in[i] = input.charAt(i-1) - '0';
    	}
    	
    	dp[0] = 1;
    	for(int i=1; i<=input.length(); i++) {
    		int temp = in[i];
    		if(1<=temp && temp<=9) {
    			dp[i] = (dp[i] + dp[i-1]) % mod; 
    		}
    		if(i==1) continue;
    		temp = in[i-1]*10 + in[i];
    		if(10<=temp && temp<=26) {
    			dp[i] = (dp[i] + dp[i-2]) % mod;
    		}
    	}
        System.out.println(Arrays.toString(dp));
    	System.out.println(dp[input.length()]);
    }
}
