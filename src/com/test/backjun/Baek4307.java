package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 개미
public class Baek4307 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        int max = -1;
        int min = -1;
        StringBuilder sb = new StringBuilder();
        while (loop-- > 0) {
            st = new StringTokenizer(reader.readLine());
            int len = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());
            for (int i = 0; i < num; i++) {
                int now = Integer.parseInt(reader.readLine());

                // 작은 것들중에 가장 큰게 min
                // 큰 것들 중에 가장 큰게 max
                if (now > len - now) {
                    max = Math.max(max, now);
                    min = Math.max(min, len - now);
                } else {
                    max = Math.max(max, len - now);
                    min = Math.max(min, now);
                }

            }
            sb.append(min).append(" ").append(max).append(System.lineSeparator());
            min = -1;
            max = -1;
        }
        System.out.println(sb.toString());
    }
}
