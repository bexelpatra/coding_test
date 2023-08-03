package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10158_failed {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int nowX = Integer.parseInt(st.nextToken());
        int nowY = Integer.parseInt(st.nextToken());
        firstX = nowX;
        firstY = nowY;
        int move = Integer.parseInt(reader.readLine());

        int dx = 1;
        int dy = 1;
        int nextX = 0;
        int nextY = 0;
        int c = 0;
        // 시간 초과
        while (move-- > 0) {
            c++;
            nextX = nowX + dx;
            nextY = nowY + dy;
            loop += 1;
            while (!(nextX <= x && nextX >= 0 && nextY <= y && nextY >= 0)) {
                if (nextX > x) {
                    dx *= -1;
                }
                if (nextY > y) {
                    dy *= -1;
                }
                if (nextX < 0) {
                    dx *= -1;
                }
                if (nextY < 0) {
                    dy *= -1;
                }
                nextX = nowX + dx;
                nextY = nowY + dy;
            }
            nowX = nextX;
            nowY = nextY;

            if (nextX == firstX && nextY == firstY && dx + dy == 2) {
                move %= loop;
            }
        }
        System.out.println(c);
        System.out.println(nextX + " " + nextY);
        // gogogo(x, y, nowX, nowY, 1, 1, move);
    }

    static int firstX, firstY, loop;

    // 메모리 초과
    // 재귀로 할 경우 메모리 초과
    public static void gogogo(int x, int y, int nowX, int nowY, int dx, int dy, int count) {
        if (count == 0) {
            System.out.println(nowX + " " + nowY);
            return;
        }
        count -= 1;
        loop += 1;
        int nextX = nowX + dx;
        int nextY = nowY + dy;
        while (!(nextX <= x && nextX >= 0 && nextY <= y && nextY >= 0)) {
            if (nextX > x) {
                dx *= -1;
            }
            if (nextY > y) {
                dy *= -1;
            }
            if (nextX < 0) {
                dx *= -1;
            }
            if (nextY < 0) {
                dy *= -1;
            }
            nextX = nowX + dx;
            nextY = nowY + dy;
        }
        // System.out.println(nextX + ":" + nextY + " count " + count);

        if (nextX == firstX && nextY == firstY && dx + dy == 2) {
            count %= loop;
            // int[] result = list.get(count % list.size());
            // System.out.println(result[0] + " " + result[1]);
            // return;
        }
        gogogo(x, y, nextX, nextY, dx, dy, count);
    }
}
