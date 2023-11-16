package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 외판원
public class Baek10971_2 {
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        facto(new int[n], new boolean[n], 0);
        System.out.println(max);
    }

    static int max = Integer.MAX_VALUE;

    // 길뺑뺑이
    public static void facto(int[] arr, boolean[] visited, int idx) {
        if (idx == arr.length) {
            // System.out.println(Arrays.toString(arr));
            max = Math.min(max, count(arr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[idx] = i;
                facto(arr, visited, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static int count(int[] arr) {
        int result = 0;
        int len = arr.length;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len - 1; i++) {
            sb
                    .append(arr[i])
                    .append(" ")
                    .append(arr[i + 1])
                    .append("=>")
                    .append(map[arr[i]][arr[i + 1]]).append("\n");
            int temp = map[arr[i]][arr[i + 1]];
            if (temp == 0) {
                return max;
            }
            result += map[arr[i]][arr[i + 1]];
        }
        if (map[arr[len - 1]][arr[0]] == 0) {
            return max;
        }
        result += map[arr[len - 1]][arr[0]];
        System.out.printf("%s ==> %d \n", Arrays.toString(arr), result);
        System.out.println(sb.toString());
        return result;
    }
}
