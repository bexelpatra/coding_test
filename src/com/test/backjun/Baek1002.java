package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1002 {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        // firstShot(reader, loop, sb);
        // secondShot(reader, loop, sb);
        stlab(reader, loop);
    }

    // https://st-lab.tistory.com/90
    // stlab , tangent_point
    private static void stlab(BufferedReader reader, int loop) throws IOException {
        while (loop-- > 0) {
            StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(tangent_point(x1, y1, r1, x2, y2, r2));
        }
    }

    public static int tangent_point(int x1, int y1, int r1, int x2, int y2, int r2) {

        int distance_pow = (int) (Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2)); // 중점간 거리 distance의 제곱

        // case 1 : 중점이 같으면서 반지름도 같을 경우
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        // case 2-1 : 두 원의 반지름 합보다 중점간 거리가 더 길 때
        else if (distance_pow > Math.pow(r1 + r2, 2)) {
            return 0;
        }

        // case 2-2 : 원 안에 원이 있으나 내접하지 않을 때
        else if (distance_pow < Math.pow(r2 - r1, 2)) {
            return 0;
        }

        // case 3-1 : 내접할 때
        else if (distance_pow == Math.pow(r2 - r1, 2)) {
            return 1;
        }

        // case 3-2 : 외접할 때
        else if (distance_pow == Math.pow(r1 + r2, 2)) {
            return 1;
        }

        else {
            return 2;
        }

    }

    // 정답
    // 2023-07-03
    private static void secondShot(BufferedReader reader, int loop, StringBuilder sb) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int distance1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int distance2 = Integer.parseInt(st.nextToken());

            double betweenRoot = Math.sqrt(square(x2 - x1) + square(y2 - y1));
            int between = square(x2 - x1) + square(y2 - y1);
            // 두 원이 일치
            if (betweenRoot == 0 && distance2 - distance1 == 0) {
                sb.append(-1);
                sb.append("\n");
                continue;
            }
            // 두원이 외접
            if (betweenRoot == distance1 + distance2) {
                sb.append(1);
            } else if (betweenRoot > distance1 + distance2) { // 두 원이 바깥에서 만나지 않음
                sb.append(0);
            } else {
                // 원이 겹치거나 원 안에서 접하거나 원 안에서 접하지 않는 경우
                if (distance1 > distance2) {
                    if (betweenRoot + distance2 == distance1) {// 두 원이 내접
                        sb.append(1);
                    } else if (betweenRoot + distance2 < distance1) {// 바깥의 큰 원이 작은 원을 감쌈
                        sb.append(0);
                    } else {
                        sb.append(2);
                    }
                } else {
                    if (betweenRoot + distance1 == distance2) {
                        sb.append(1); // 두 원이 내접
                    } else if (betweenRoot + distance1 < distance2) {// 바깥의 큰 원이 작은 원을 감쌈
                        sb.append(0);
                    } else {
                        sb.append(2);
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }

    // 틀림
    private static void firstShot(BufferedReader reader, int loop, StringBuilder sb) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int distance1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int distance2 = Integer.parseInt(st.nextToken());

            double betweenRoot = Math.sqrt(square(x2 - x1) + square(y2 - y1));
            int between = square(x2 - x1) + square(y2 - y1);
            if (betweenRoot == 0 && distance2 - distance1 == 0) { // 두 원이 일치
                sb.append(-1);
                continue;
            }

            if (betweenRoot == distance1 + distance2) { // 두원이 외접
                sb.append(1);
            } else if (betweenRoot > distance1 + distance2) { // 두 원이 바깥에서 만나지 않음
                sb.append(0);
            } else {
                // 접점이 두개 또는 원 안에 있다.
                // 아우터를 찾는다.

                if (betweenRoot + distance1 == distance2 || betweenRoot + distance2 == distance1) {
                    sb.append(1);
                } else if (betweenRoot + distance1 < distance2) {
                    sb.append(0);
                } else if (betweenRoot + distance2 < distance1) {

                } else {
                    sb.append(2);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int square(int x) {
        return x * x;
    }
}
