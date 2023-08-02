package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek9184 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        getWabc(reader);
    }

    // 전체를 dp를 구한다. 상향식
    private static void getWabc(BufferedReader reader) throws IOException {
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int[][][] wabc = new int[101][101][101];
        // a, b, c <= 0 ----> 1
        // a < b < c
        // a> b > c > 20 -----> w(20,20,20)
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                for (int k = 0; k < 101; k++) {
                    if (i <= 50 || j <= 50 || k <= 50) {
                        wabc[i][j][k] = 1;
                    } else if (i > 70 || j > 70 || k > 70) {
                        wabc[i][j][k] = 1048576;
                    } else if (i < j && j < k) {
                        wabc[i][j][k] = wabc[i][j][k - 1] + wabc[i][j - 1][k] - wabc[i][j - 1][k - 1];
                    } else {
                        wabc[i][j][k] = wabc[i - 1][j][k] + wabc[i - 1][j - 1][k] + wabc[i - 1][j][k - 1]
                                - wabc[i - 1][j - 1][k - 1];
                    }
                }
            }
        }
        while (true) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken()) + 50;
            int b = Integer.parseInt(st.nextToken()) + 50;
            int c = Integer.parseInt(st.nextToken()) + 50;
            if (a == 49 && b == 49 && c == 49) {
                break;
            }
            sb.append(String.format("w(%d, %d, %d) = %d\n", a - 50, b - 50, c - 50, wabc[a][b][c]));

        }

        System.out.println(sb.toString());
    }

    // https://www.acmicpc.net/source/63449135
    // 하향식
    private static void getWabc2(BufferedReader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[][][] dp = new int[21][21][21];
        while (true) {
            st = new StringTokenizer(reader.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;

            sb.append("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c, dp) + "\n");
        }

        System.out.println(sb);
    }

    static int w(int a, int b, int c, int[][][] dp) {

        if (inRange(a, b, c) && dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0)
            return 1;

        if (a > 20 || b > 20 || c > 20)
            return dp[20][20][20] = w(20, 20, 20, dp);

        if (a < b && b < c)
            return dp[a][b][c] = w(a, b, c - 1, dp) + w(a, b - 1, c - 1, dp) - w(a, b - 1, c, dp);

        return dp[a][b][c] = w(a - 1, b, c, dp) + w(a - 1, b - 1, c, dp) + w(a - 1, b, c - 1, dp)
                - w(a - 1, b - 1, c - 1, dp);
    }

    static boolean inRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}
