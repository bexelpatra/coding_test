package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1182 {
    static long result = 0l;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());
            arr[i] = now;
        }

        for (int i = 0; i < arr.length; i++) {
            recur(arr, new boolean[arr.length], 0, 0, i + 1, 0, s);
        }

        System.out.println(result);
    }

    public static void recur(int[] arr, boolean[] used, int idx, int count, int targetCount, int sum, int targetNum) {
        if (count == targetCount) {
            // System.out.println(Arrays.toString(used));
            if (sum == targetNum) {
                result += 1;
            }
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (!used[i]) {
                used[i] = true;
                recur(arr, used, i + 1, count + 1, targetCount, sum + arr[i], targetNum);
                used[i] = false;
            }
        }
    }
}
