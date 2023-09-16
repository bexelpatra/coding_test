package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(reader.readLine());

        int left = 1;
        int right = left + m - 1;
        int[] apples = new int[j];
        int count = 0;
        for (int i = 0; i < apples.length; i++) {
            apples[i] = Integer.parseInt(reader.readLine());
        }
        for (int i = 0; i < apples.length; i++) {
            if (left > apples[i]) {
                count += left - apples[i];
                left = apples[i];
                right = left + m - 1;
                if (right > n) {
                    right = n;
                }
            } else if (right < apples[i]) {
                count += apples[i] - right;
                right = apples[i];
                left = right - m + 1;
                if (left < 0) {
                    left = 0;
                }
            }
            // System.out.printf("count %d , left %d, right %d\n", count, left, right);
        }
        System.out.println(count);

    }
}
