package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Baek11051 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        BigDecimal b = new BigDecimal(n);

        n -= 1;
        while (n-- >= k) {
            b = b.multiply(BigDecimal.valueOf(n));
        }
        while (k-- >= 2) {
            b = b.divide(BigDecimal.valueOf(k));
        }

        System.out.println(b.remainder(BigDecimal.valueOf(10007)));
    }
}
