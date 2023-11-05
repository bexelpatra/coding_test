package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 이분탐색의 전형...
public class Baek2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(reader.readLine());
        int min = 0;
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while (min < max) {
            int mid = (max + min) / 2;
            long sum = 0;
            for (int i : arr) {
                int temp = i - mid;
                if (temp > 0) {
                    sum += temp;
                }
            }
            // System.out.printf("%d %d %d %d\n", min, mid, max, sum);
            if (sum < m) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        System.out.println(min - 1);
        // fail1(reader);

    }

    // fail
    private static void fail1(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(trees);
        int idx = trees.length - 1;

        int max = trees[idx];
        int myTree = 0;
        int count = 1;

        while (myTree < m) {
            if (idx - 1 >= 0) {
                int nextTree = trees[idx] - trees[idx - 1];
                myTree += nextTree * count;

                idx -= 1;
                count += 1;
            } else {
                break;
            }
        }

        int sum = 0;
        int i = 0;
        System.out.println(count);
        System.out.println(n - idx - 1);
        while (Math.abs(myTree - m) > (sum + i) * (n - idx - 1)) {
            i += 1;
        }

        System.out.println(trees[idx] + i);
    }

}
