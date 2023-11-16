package com.test.TEST;

import java.util.Arrays;

public class TTest_bit {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(1 << 0);
        int[] arr = new int[n];
        re(arr, 0, 0);
    }

    public static void re(int[] arr, int idx, int visited) {

        if (arr.length == idx) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if ((visited & (1 << i)) == 0) {
                visited = visited | (1 << i);
                arr[idx] = i;
                re(arr, idx + 1, visited);
                visited -= (1 << i);
            }
        }
    }
}
