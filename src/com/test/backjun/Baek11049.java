package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11049 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][2];
        dp = new int[n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0] = map[0][0] * map[0][1];
        if (n > 1) {
            dp[1] = map[0][0] * map[1][0] * map[1][1];
        }
        if (n > 2) {
            // reduce2(map, new int[][] { map[0], map[1], map[2] }, 2);
            reduce3(map);
            return;
        }
        System.out.println(dp[n - 1]);
        // System.out.println(Arrays.toString(dp));

    }

    static int[] dp = null;

    public static int[][] compare(int[] a, int[] b, int[] c, int idx) {
        int f = a[0] * (b[0] * b[1] + c[0] * c[1]);
        int r = c[1] * (b[0] * b[1] + a[0] * a[1]);
        // 비교는 ? a[1] b[1]만 하면 되는듯
        if (f > r) {
            a[1] = b[1];
            b = c;
            c = null;
            dp[idx] = r;
        } else {
            b[1] = c[1];
            c = null;
            dp[idx] = f;
        }
        return new int[][] { a, b, c };

    }

    public static int[][] compare2(int[] a, int[] b, int[] c, int idx) {
        boolean flag = a[1] > b[1];
        if (flag) {
            a[1] = b[1];
            b = c;
            dp[idx] = a[0] * a[1] * b[1];
        } else {
            b[1] = c[1];
            dp[idx] = b[0] * b[1] * c[1];
        }
        System.out.println(dp[idx]);
        return new int[][] { a, b, c };
    }

    public static void reduce(int[][] arr, int[][] compareArr, int idx) {
        if (idx == arr.length) {
            return;
        }
        int[][] result = compare(arr[0], arr[1], arr[2], idx);
        result[2] = arr[idx];
        idx += 1;
        reduce(arr, result, idx);
    }

    public static void reduce2(int[][] arr, int[][] compareArr, int idx) {
        if (idx == arr.length) {
            return;
        }
        int[][] result = compare2(arr[0], arr[1], arr[2], idx);
        result[2] = arr[idx];
        idx += 1;
        reduce2(arr, result, idx);
    }

    public static void reduce3(int[][] arr) {
        int len = arr.length;
        int[] inner = new int[len];

        int result = 0;
        for (int i = 0; i < len; i++) {
            if (i == len - 2) {
                break;
            }
            int[] a = arr[i];
            int[] b = arr[i + 1];
            int[] c = arr[i + 2];
            // System.out.println(Arrays.toString(a) + Arrays.toString(b) +
            // Arrays.toString(c));
            boolean flag = a[1] > b[1];
            int val = 0;
            if (flag) {
                val = a[0] * b[0] * b[1];
                b[0] = a[0];
            } else {
                val = b[0] * c[0] * c[1];
                c[0] = b[0];
                b[0] = a[0];
                b[1] = a[1];
            }
            a[0] = a[1] = 0;
            inner[i] = val;
            result += val;
        }
        int[] a = arr[len - 2];
        int[] b = arr[len - 1];
        // System.out.println(Arrays.toString(a) + Arrays.toString(b));
        inner[len - 2] = a[0] * a[1] * b[1];
        result += inner[len - 2];
        // System.out.println(Arrays.toString(inner));
        System.out.println(result);
    }
}
