package com.test.TEST;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr = IntStream.generate(() -> {
            return (int) (Math.random() * 100) + 1;
        }).limit(10).sorted().toArray();

        System.out.println(Arrays.toString(arr));
        
        System.out.println(lowwer(arr, arr[3] ));
        System.out.println(higher(arr, arr[3] ));
        
        int[] arr2 = new int[]{1,3,6};
        System.out.println(Arrays.toString(arr2));
        System.out.println(lowwer(arr2, 1));
        System.out.println(lowwer(arr2, 1));
        System.out.println(lowwer(arr2, 3));
        System.out.println(lowwer(arr2, 7));
        System.out.println(lowwer(arr2, 8));
        // System.out.println(higher(arr2, 3));
    }

    // 같으면 low로 땡긴다.
    public static int lowwer(int[] arr, int key) {
        int lo = 0;
        int hi = arr.length -1;
        while (lo < hi) {
            int mid = ((hi + lo) / 2);
            System.out.printf("lowwer arr[%d] = %d, arr[%d] = %d,  arr[%d] = %d key : %d\n", lo,arr[lo], hi,arr[hi], mid, arr[mid],key);
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
        int hi = arr.length-1;
        while (lo < hi) {
            int mid = ((hi + lo) / 2);
            System.out.printf("higher arr[%d] = %d, arr[%d] = %d,  arr[%d] = %d key : %d\n", lo,arr[lo], hi,arr[hi], mid, arr[mid],key);
            if (key < arr[mid]) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;

    }
}
