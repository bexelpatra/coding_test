package com.test.practice.e_exhaustive_search;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    // #1 순열(방식 3) 프로그래머스에서 다른 사람들이 푼 방식
    // 공통적으로 반복문안에 재귀가 들어간다. 원리를 파악하려면 시간이 조금 더 걸리겠다...
    public static void permutation(String prefix, String str, Set<Integer> set) {
        int n = str.length();
        if (n == 0) System.out.println(prefix);
        if(!prefix.equals("")) set.add(Integer.valueOf(prefix));
        for (int i = 0; i < n; i++)
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), set);
    }
    // #2 조합
    //https://codevang.tistory.com/297
    public static void combination(List<String> arr, List<String> result, int index, int n, int r) {

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

    public static void myPerm(List<String> arr, List<String> result, int n, int r) {

        if (r == 0) {
            System.out.println(result.toString());
            return;
        }

        for (int i = 0; i < n; i++) {
            result.add(arr.remove(i));
            myPerm(arr,result,n-1,r-1);
            arr.add(i,result.remove(result.size()-1));
        }
    }
//    static int count = 0;
    public static int fibo(int n){
        if(n == 1 || n == 2){
            return 1;
        }
        return fibo(n-1) + fibo(n-2);
    }

    public static String re(){

        return "";
    }
}
