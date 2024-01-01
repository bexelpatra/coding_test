package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int loop = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        int[] dp = new int[n+1];
        st = new StringTokenizer(reader.readLine());
        int now = 0;
        for (int i = 1; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            now+= arr[i];
            dp[i] = now;
        }
        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(dp));
        while(loop-->0){
            st = new StringTokenizer(reader.readLine());
            int start =Integer.parseInt(st.nextToken())-1;
            int enc =Integer.parseInt(st.nextToken());

            sb.append(dp[enc]- dp[start]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
