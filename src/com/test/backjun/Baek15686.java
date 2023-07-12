package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15686 {
    static List<int[]> houses;
    static List<int[]> shops;
    static int mininum = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        houses = new ArrayList<>();
        shops = new ArrayList<>();
        // 값 입력받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                int type = Integer.parseInt(st.nextToken());
                if (type == 1) {
                    houses.add(new int[] { i, j });
                } else if (type == 2) {
                    shops.add(new int[] { i, j });
                }
            }
        }

        int[] arr = new int[shops.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        combi(arr, new boolean[arr.length], new int[M], 0);
        System.out.println(mininum);
    }

    // 살아남을 치킨집 선택하기(조합)
    private static void combi(int[] arr, boolean[] used, int[] result, int now) {
        if (now == result.length) {
            mininum = Math.min(mininum, doJob(result));
            return;
        }
        for (int i = now; i < arr.length; i++) {
            if (!used[i]) {
                if (now > 0 && result[now - 1] > arr[i])
                    continue;
                result[now] = arr[i];
                used[i] = true;
                combi(arr, used, result, now + 1);
                used[i] = false;
            }

        }
    }

    // 선택받은 치킨집들과 집의 거리재기(모든 치킨집과 집의 거리를 재면서 최소값을 저장한다.)
    private static int doJob(int[] result) {
        int sum = 0;
        int[] prices = new int[houses.size()];
        Arrays.fill(prices, Integer.MAX_VALUE);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < houses.size(); j++) {
                prices[j] = Math.min(calc(shops.get(result[i]), houses.get(j)), prices[j]);
            }
        }
        for (int i : prices) {
            sum += i;
        }
        return sum;
    }

    // 거리 재기
    private static int calc(int[] chicken, int[] house) {
        int x = chicken[0] - house[0] > 0 ? chicken[0] - house[0] : house[0] - chicken[0];
        int y = chicken[1] - house[1] > 0 ? chicken[1] - house[1] : house[1] - chicken[1];
        return x + y;
    }
}
