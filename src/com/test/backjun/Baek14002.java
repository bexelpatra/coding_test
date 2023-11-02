package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek14002 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> result = new ArrayList<>();

        int max = 0;
        int maxIdx = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
            dp[i][1] = -1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i][0] < dp[j][0] + 1) {
                    dp[i][0] = dp[j][0] + 1;
                    dp[i][1] = j;
                    if (max < dp[i][0]) {
                        max = dp[i][0];
                        maxIdx = i;
                    }
                }
            }
        }

        int[] now = dp[maxIdx];
        result.add(arr[maxIdx]);

        while (true) {
            if (now[1] < 0) {
                break;
            }
            maxIdx = now[1];
            now = dp[maxIdx];
            result.add(arr[maxIdx]);
            if (now[1] == -1) {
                break;
            }
        }

        int len = result.size();
        int[] answer = new int[len];
        StringBuilder sb = new StringBuilder();
        sb.append(len).append("\n");
        int idx = 0;
        while (len-- > 0) {
            answer[idx++] = result.get(len);
        }
        for (int i = 0; i < answer.length; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
