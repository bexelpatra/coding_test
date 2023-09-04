package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 전깃줄
/*
 * 나의 접근 방식
 * 1. 전선이 겹치는 것을 구한다.
 * 2. 많이 겹치는 전선부터 하나씩 들어낸다.
 */
public class Baek2565 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[n][];
        int[][] no = new int[n][];
        int[][] ro = new int[n][];

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

        List<Integer>[] list = new List[n];
        for (int i = 0; i < list.length; i++) {
            List<Integer> now = list[i];

        }

        System.out.println(sb.toString());
    }
}
