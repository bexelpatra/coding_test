package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek15651 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i+1;
        }
        recursive(new int[m], 0);
        System.out.println(sb.toString());
    }
    static int[] ints;
    static StringBuilder sb = new StringBuilder();
    public static void recursive(int[] arr, int idx){
        if(arr.length == idx){
            // System.out.println(Arrays.toString(arr));
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < ints.length; i++) {
            arr[idx] = ints[i]; 
            recursive(arr, idx+1);
        }
    }
}
