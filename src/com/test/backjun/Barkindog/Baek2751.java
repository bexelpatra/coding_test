package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2751 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] yes = new boolean[1_000_000 * 2 + 1];
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            yes[now + 1_000_000] = true;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < yes.length; i++) {
            if(yes[i]){
                sb.append(i -  1_000_000).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    // 시간 초과
    private static void getSb() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        StringBuilder sb =  new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
