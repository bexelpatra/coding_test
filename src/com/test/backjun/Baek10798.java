package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[5];
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.readLine();
            max = Math.max(max, arr[i].length());
        }
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (idx < max) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i].length() > idx) {
                    sb.append(arr[i].charAt(idx));
                }
            }
            idx += 1;
        }
        System.out.println(sb.toString());

    }
}
