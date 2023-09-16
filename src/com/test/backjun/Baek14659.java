package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14659 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int temp = 0;
        int count = 0;
        int max = 0;
        while (st.hasMoreTokens()) {
            int now = Integer.parseInt(st.nextToken());
            if (temp > now) {
                count++;
            } else {
                temp = now;
                max = Math.max(max, count);
                count = 0;
            }
        }
        System.out.println(Math.max(max, count));
        // getMax();
    }

    private static void getMax() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] mt = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < mt.length; i++) {
            mt[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 0; i < mt.length - 1; i++) {
            int now = 0;
            for (int j = i + 1; j < mt.length; j++) {
                if (mt[i] > mt[j]) {
                    now += 1;
                } else {
                    break;
                }
            }
            max = Math.max(max, now);
        }
        System.out.println(max);
    }
}
