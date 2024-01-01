package com.test.backjun.Barkindog;

/*
 * 속도가 너무 느려서 맞춘 사람들 문제를 보니 풀이한 방법이 다르다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1915_refer {
    static int [][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        dp = new int[n + 1][m + 1];
        int answer = 0;

        for (int i = 1; i <= n; i++) {
            String input = br.readLine();
            for (int j = 1; j <= m; j++) {
                char c = input.charAt(j - 1);

                if (c == '1') {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                    answer = Math.max(answer, dp[i][j]);
                    // Print(dp);
                }
            }
        }

        System.out.print(answer * answer);
    }
    public static void Print(int[][] map){
        for (int[] is : map) {
            System.out.println(Arrays.toString(is));
        }
        System.out.println();
    }
}