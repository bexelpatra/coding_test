package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1965 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] boxes = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < boxes.length; i++) {
            boxes[i] = Integer.parseInt(st.nextToken());
        }
        int[] dp = new int[n];

        int max = -1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (boxes[j] < boxes[i] && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(dp[i], max);
                }
            }
        }

        // System.out.println(Arrays.toString(dp));
        // System.out.println(Arrays.stream(dp).max().getAsInt());
        System.out.println(max);
    }
}
