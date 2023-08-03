package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10158_refer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());

        int t = Integer.parseInt(reader.readLine());
        int nextX = nowX + t % (x * 2);
        int nextY = nowY + t % (y * 2);
        if (nextX > x) {
            // nextX = x - (nextX - x);
            nextX = Math.abs(x * 2 - nextX);
        }
        if (nextY > y) {
            // nextY = y - (nextY - y);
            nextY = Math.abs(y * 2 - nextY);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(nextX).append(" ").append(nextY);
        System.out.println(sb.toString());
    }
}
