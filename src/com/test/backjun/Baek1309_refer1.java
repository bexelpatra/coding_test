package com.test.backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

//https://steady-coding.tistory.com/156
/*
 * 오답노트?
 * 1.나의 생각
 * - 점화식을 세울 때 n번째 줄에서 k의 점을 찍는 것으로 생각했다
 * - k의 점을 찍는다면 n개중에서 k개의 줄을 선택하고, k개의 줄이 인접하는지 안하는지 여부를 생각해줘야 계산이 가능해 보인다.
 * 
 */
public class Baek1309_refer1 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        final int MOD = 9901;
        int N = Integer.parseInt(br.readLine());

        // dp[i][j] : i번째 줄의 j번째 칸에 동물을 놓을 수 있는 경우의 수
        // j = 0 : 아무 동물도 놓지 않음
        // j = 1 : 첫 번째 칸에 동물을 놓음
        // j = 2 : 두 번째 칸에 동물을 놓음
        long[][] dp = new long[N + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1; // 기저 사례
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            for (int j = 0; j < 3; j++) {
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        long ans = (dp[N][0] + dp[N][1] + dp[N][2]) % MOD;
        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

}
