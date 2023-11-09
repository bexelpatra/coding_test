package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1977 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int first = 0;
        int sum = 0;

        int num = 1;
        int sq = 1;
        while (sq <= m) {
            sq = num * num;
            if (sq >= n && sq <= m) {
                System.out.println(sq);
                sum += sq;
                if (first == 0) {
                    first = sq;
                }
            }
            num += 1;
        }
        StringBuilder sb = new StringBuilder();
        if (first != 0) {
            sb.append(sum).append("\n");
            sb.append(first);

        } else {
            sb.append(-1);
        }
        System.out.println(sb.toString());
    }
}
