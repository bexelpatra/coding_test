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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < C; i++) {
            st = new StringTokenizer(reader.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int restM = 0;
            int restN = 0;
            int diff = Math.abs(M - N);
            int rest = 0;
            if (N >= M) {
                restM = K - N;
                restN = K - N;
                rest = diff - restN;
            } else {
                restM = K - M;
                restN = K - M + 1;
                rest = diff - restN;
            }
            if (rest >= 2) {
                result.append(0).append(System.lineSeparator());
            } else {
                result.append(1).append(System.lineSeparator());
            }
            sb.append(String.format("%d %d %d %d %d %d %s ", M, N, restM, restN, diff,
                    rest, rest >= 2 ? "실패" : "성공"))
                    .append(System.lineSeparator());

        }
        System.out.println(sb.toString());
        // System.out.println(result.toString());
    }

}
