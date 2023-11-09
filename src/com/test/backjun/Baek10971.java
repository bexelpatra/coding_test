package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 외판원
public class Baek10971 {
    static int[][] map;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        map = new int[n + 1][n + 1];
        StringTokenizer st;
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 다익스트라를 정정만큼 돌리면 안되는가?
    }

    public static void dik(int start) {
        int[][] dist = new int[map.length][map.length];
        for (int i = 0; i < dist.length; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE / 3);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> map[o1[0]][o1[1]] - map[o2[0]][o2[1]]);

    }

    // 길뺑뺑이
    public static void facto(int[] arr, boolean[] visited, int idx) {
        if (idx + 1 == arr.length) {
            System.out.println(Arrays.toString(arr));
            return;
        }

    }
}
