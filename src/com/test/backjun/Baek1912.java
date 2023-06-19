package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1912 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sol1(reader);
        sol2(reader);
    }

    private static void sol2(BufferedReader reader) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        int[] dp = new int[n];
        dp[0] = list[0];
        for (int i = 1; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (dp[i - 1] < 0) {
                dp[i] = Math.max(dp[i - 1], list[i]);
            } else {
                dp[i] = dp[i - 1] + list[i];
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());

    }

    private static void sol1(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] list = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        list[0] = Integer.parseInt(st.nextToken());
        dp[0] = list[0];
        for (int i = 1; i < list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
            if (list[i] > 0) {
                dp[i] = Math.max(dp[i - 1], 0) + list[i];
            } else {
                if (dp[i - 1] < 0) {
                    dp[i] = Math.max(dp[i - 1], list[i]);
                } else {
                    dp[i] = dp[i - 1] + list[i];
                }
            }
        }

        System.out.println(Arrays.toString(dp));
        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
