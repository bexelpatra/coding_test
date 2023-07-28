package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//케빈 베이컨의 6단계 법칙
public class Baek1389 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        // getFloydWarshall(reader);

    }

    private static void getFloydWarshall(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int users = Integer.parseInt(st.nextToken()); // 2 ~ 100
        int relations = Integer.parseInt(st.nextToken()); // 1 ~ 5000
        int[][] map = new int[users + 1][users + 1];

        for (int i = 1; i < map.length; i++) {
            Arrays.fill(map[i], 1000000);
            map[i][i] = 0;
            map[i][0] = 0;
        }
        for (int i = 0; i < relations; i++) {
            st = new StringTokenizer(reader.readLine());
            int userA = Integer.parseInt(st.nextToken());
            int userB = Integer.parseInt(st.nextToken());
            map[userA][userB] = 1;
            map[userB][userA] = 1;

        }

        for (int layover = 1; layover < map.length; layover++) {
            for (int from = 1; from < map.length; from++) {
                for (int to = 1; to < map.length; to++) {
                    if (map[from][to] > map[from][layover] + map[layover][to]) {
                        map[from][to] = map[from][layover] + map[layover][to];
                    }
                }
            }
        }
        int min = 100000000;
        int num = 0;
        for (int i = 1; i < map.length; i++) {
            int sum = Arrays.stream(map[i]).sum();
            if (min > sum) {
                num = i;
                min = sum;
            }
        }
        System.out.println(num);
    }
}
