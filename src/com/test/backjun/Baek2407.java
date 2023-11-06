package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Baek2407 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        long ans = 1;
        BigDecimal d = new BigDecimal(ans);
        for (int i = n-m+1; i <= n; i++) {
            d = d.multiply(new BigDecimal(i));
        }
        for (int i = 1; i <= m; i++) {
            d = d.divide(new BigDecimal(i));
        }
        System.out.println(d.toString());
    }
}
