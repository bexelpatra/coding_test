package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/138
public class Baek2565 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[n][];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[] { a, b };
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        StringBuilder sb = new StringBuilder();
        Arrays.stream(arr).forEach(t -> sb.append(t[0]).append(" ").append(t[1]).append(" "));

        System.out.println(sb.toString());
    }
}
