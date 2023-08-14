package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10219 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // System.out.println(new String(reverse(reader.readLine())));
        // if (true) {
        // return;
        // }
        int t = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            for (int i = 0; i < y; i++) {
                sb.append(reverse(reader.readLine())).append(System.lineSeparator());
            }
        }
        System.out.println(sb.toString());
    }

    public static char[] reverse(String ori) {
        char[] arr = ori.toCharArray();
        char temp = ' ';
        for (int i = 0; i < arr.length / 2; i++) {
            temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}
