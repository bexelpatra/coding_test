package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 브루트 포스 -> 모든 경우의수를 검색했다.
public class Baek10819 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean[] used = new boolean[n];

        recursive(arr, used, new int[n], 0);
        System.out.println(max);
    }

    static int max = 0;

    private static void recursive(int[] arr, boolean[] used, int[] temp, int idx) {

        if (check(used)) {
            max = Math.max(max, sum(temp));
            // System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!used[i]) {

                temp[idx] = arr[i];
                used[i] = true;
                recursive(arr, used, temp, idx + 1);
                used[i] = false;
            }
        }
    }

    private static int sum(int... arr) {
        int result = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            result += Math.abs(arr[i] - arr[i + 1]);
        }
        return result;
    }

    private static boolean check(boolean[] arr) {
        for (boolean b : arr) {
            if (!b) {
                return false;
            }
        }
        return true;
    }
}
