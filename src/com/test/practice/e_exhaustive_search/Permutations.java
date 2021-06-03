package com.test.practice.e_exhaustive_search;

import java.util.Arrays;
import java.util.List;

/**
 * 순열 알고리즘에 대한 공부
 */
public class Permutations {

    // #1 순열(방식 1)
    //https://gorakgarak.tistory.com/522
    public static void perm(int[] arr, int depth, int n, int k) {
        if (depth == k) { // 한번 depth 가 k로 도달하면 사이클이 돌았음. 출력함.
            print(arr,k);
            return;
        } for (int i = depth; i < n; i++) {
            swap(arr, i, depth);
            perm(arr, depth + 1, n, k);
            swap(arr, i, depth);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private static void print(int[] arr, int k) {
        for (int i = 0; i < k; i++) {
            if (i == k - 1) System.out.println(arr[i]);
            else System.out.print(arr[i] + ",");
        }
    }

    // #1 순열(방식2)
    //https://codevang.tistory.com/297
    public static void perm2(List<String> arr, List<String> result, int n, int r) {

        if (r == 0) {
            System.out.println(result.toString());
            return;
        }

        for (int i = 0; i < n; i++) {

            result.add(arr.remove(i));
            perm2(arr, result, n - 1, r - 1);
            arr.add(i, result.remove(result.size() - 1));
        }
    }

    private void perm2(List<Integer> nums, int[] result, int depth, int n, int r) {

        if (depth == r) {
            System.out.println(Arrays.toString(result));
            return;
        }

        for (int i = 0; i < n - depth; i++) {
            result[depth] = nums.remove(i);
            perm2(nums, result, depth + 1, n, r);
            nums.add(i, result[depth]);
        }
    }
    // #2 조합
    //https://codevang.tistory.com/297
    private static void combination(List<String> arr, List<String> result, int index, int n, int r) {

        if (r == 0) {

            System.out.println(result.toString());
            return;
        }

        for (int i = index; i < n; i++) {

            result.add(arr.get(i));
            combination(arr, result, i + 1, n, r - 1);
            result.remove(result.size() - 1);
        }
    }
}
