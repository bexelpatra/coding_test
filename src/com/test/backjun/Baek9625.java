package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek9625 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()) + 1;

        ref(n - 1);
        int[][] dp = new int[n + 1][2];
        dp[1]['a' - 'a'] = 1;
        dp[1]['b' - 'a'] = 0;
        for (int i = 2; i < n + 1; i++) {
            dp[i][0] = dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1];
        }
        System.out.printf("%d %d", dp[n][0], dp[n][1]);
    }

    public static void ref(int n) {
        StringBuilder sb = new StringBuilder("a");
        StringBuilder temp = null;
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            temp = new StringBuilder();
            a = b = 0;
            for (int j = 0; j < sb.length(); j++) {
                if (sb.charAt(j) == 'a') {
                    temp.append('b');
                    b += 1;
                } else {
                    temp.append('b').append('a');
                    b += 1;
                    a += 1;
                }
            }
            sb = temp;
            temp = null;
        }
        // System.out.printf("\n %s ||| a : %d b : %d", sb.toString(), a, b);
        System.out.printf("%d %d\n", a, b);
    }
}
