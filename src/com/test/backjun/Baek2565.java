package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2565 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i] = new int[] { a, b };
        }
        Arrays.sort(arr, (o1, o2) -> {
            return o1[0] - o2[0];
        });
        List<Integer>[] cross = new ArrayList[n];
        Arrays.stream(cross).forEach(t -> t = new ArrayList<>());
        for (int i = 0; i < arr.length - 1; i++) {
            int[] now = arr[i];
            for (int j = 0; j < now.length; j++) {

            }
        }
    }
}
