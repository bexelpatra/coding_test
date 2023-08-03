package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1052 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long target = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        // long target = 48;
        // long k = 3;

        // if (true) {
        // return;
        // }
        if (target <= k) {
            System.out.println(0);
            return;
        }
        long result = Long.MAX_VALUE;
        long temp = 0;
        while (k-- > 0) {
            long[] now = pow(target);
            result = Math.min(result, now[2] - target);
            target -= now[1];
            System.out.printf("%d %d %d %d %d\n", now[0], now[1], now[2], target, result);
            if (now[0] == 0) {
                break;
            }
        }

        System.out.println(result);

    }

    public static long[] pow(long target) {
        int n = 0;
        long val = 1;
        while (target > val) {
            val *= 2;
            n += 1;
        }
        return new long[] { n - 1, val / 2, val };
    }
}
