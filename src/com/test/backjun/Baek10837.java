package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10837 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(reader.readLine());
        int C = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int restM = 0;
            int restN = 0;
            if (N >= M) {
                restM = K - N;
                restN = K - N;
            } else {
                restM = K - M;
                restN = K - M + 1;
            }
            sb.append(String.format("%d %d %d %d %d ", M, N, restM, restN, Math.abs(M - N)))
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

}
