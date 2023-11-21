package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 하노이 개같은 하노이...
public class Baek11729 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        hanoi(n, 1, 2, 3);

    }

    public static void hanoi(int n, int start, int mid, int end) {
        if (n == 1) {
            System.out.printf("%d %d\n", start, end);
            return;
        }
        hanoi(n - 1, start, end, mid);
        System.out.printf("%d %d\n", start, end);
        hanoi(n - 1, mid, start, end);
    }
}
