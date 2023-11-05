package com.test.TEST;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = IntStream.generate(() -> {
            return (int) (Math.random() * 100) + 1;
        }).limit(15).sorted().toArray();

        System.out.println(Arrays.toString(arr));

        System.out.println(lowwer(arr, arr[0]));
        System.out.println(higher(arr, -1));
    }

    // 같으면 low로 땡긴다.
    public static int lowwer(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = ((hi + lo) / 2);
            System.out.printf("lowwer %d %d %d key : %d\n", lo, hi, mid, key);
            if (key <= arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

    }

    // 같으면 hi로 땡긴다.
    public static int higher(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length;
        while (lo < hi) {
            int mid = ((hi + lo) / 2);
            System.out.printf("higher %d %d %d key : %d\n", lo, hi, mid, key);
            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

    }
}
