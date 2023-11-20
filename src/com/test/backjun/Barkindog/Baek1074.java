package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/* 
    1. 재귀 및 분할정복 문제같지만 규칙을 찾아 풀었다.

 */
public class Baek1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        // System.out.println(getX(c));
        // System.out.println(getX(r) * 2);

        int answer = getX(c) + getX(r) * 2;

        System.out.println(answer);
    }

    public static int getX(int x) {
        String bi = Integer.toString(x, 2);
        int count = 0;
        int e = 0;
        for (int i = bi.length() - 1; i >= 0; i--) {
            if (bi.charAt(i) == '1') {
                count += Math.pow(2, e);
            }
            e += 2;
        }
        return count;
    }

}
