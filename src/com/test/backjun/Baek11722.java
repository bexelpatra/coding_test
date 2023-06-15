package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    6
    10 30 10 20 20 10
 */
public class Baek11722 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // DP(reader);
        switching(reader);
    }

    private static void switching(BufferedReader reader) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] list = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int listIndex = 1;
        list[0] = arr[0];

        for (int i = 1; i < n; i++) {
            // 앞의 숫자보다 작으면 추가
            if (list[listIndex - 1] > arr[i]) {
                list[listIndex] = arr[i];
                listIndex += 1;
            } else {
                int lo = 0;
                int hi = listIndex;
                while (lo < hi) {
                    int mid = (hi + lo) / 2;
                    if (list[mid] > arr[i]) {
                        lo = mid + 1;
                    } else {
                        hi = mid;
                    }
                }
                list[lo] = arr[i];
            }
        }
        System.out.println(listIndex);
    }

    private static void DP(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
