package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10816 {
    public static void main(String[] args) throws Exception {
        int con = 10_000_000;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        int[] arr = new int[con * 2 + 1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken()) + con;
            arr[now] += 1;
        }
        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int now = Integer.parseInt(st.nextToken()) + con;
            sb.append(arr[now]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }
}
