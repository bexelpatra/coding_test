package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Baek1629 {
    static long c;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        c = Long.parseLong(st.nextToken());

        System.out.println(pow(a, b));
        // getD(reader);

    }

    public static long pow(long a, long expo) {
        if (expo == 1) {
            return a % c;
        }
        long temp = pow(a, expo / 2);
        if (expo % 2 == 1) {
            return (temp * temp % c) * a % c;
        }
        return temp * temp % c;
    }

    // 메모리 초과 실패
    private static void getD(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int now = 1;
        BigDecimal d = new BigDecimal(1);
        for (int i = 0; i < b; i++) {
            now *= a;
            System.out.println(now + ":" + now / c + " : " + now % c);
        }
        // System.out.println(d.toString());

        System.out.println(d.toString());
    }
}
