package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int idx = 0;
        int count = 0;
        while (n - idx > 0) {
            idx += 1;
            if (n % idx == 0) {
                count += 1;
            }
            if (count == m) {
                System.out.println(idx);
                return;
            }
        }
        System.out.println(0);
        return;
    }
}
