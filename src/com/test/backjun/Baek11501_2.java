package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11501_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            long result = 0;

            int max = arr[n - 1];
            for (int j = arr.length - 2; j >= 0; j--) {
                if (arr[j] < max) {
                    result += max - arr[j];
                } else {
                    max = arr[j];
                }
            }

            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void fail1(BufferedReader reader, StringBuilder sb) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int j = 0; j < arr.length; j++) {
            arr[j] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        int count = 0;
        int val = 0;
        for (int j = 0; j < arr.length - 1; j++) {
            if (arr[j] < arr[j + 1]) {
                count += 1;
                val += arr[j];
            } else {
                result += arr[j] * count - val;
                count = 0;
                val = 0;
            }
        }
        if (arr[n - 1] > arr[n - 2]) {
            result += arr[n - 1] * count - val;
        }

        sb.append(result).append("\n");
    }
}
