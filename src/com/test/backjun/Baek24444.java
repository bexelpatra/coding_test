package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            list.add(new PriorityQueue<>());
        }
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        boolean[] visited = new boolean[v + 1];
        int[] result = new int[v + 1];
        int idx = 1;
        result[start] = idx++;
        visited[start] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int poll = q.poll();
            PriorityQueue<Integer> pq = list.get(poll);
            while (!pq.isEmpty()) {
                int now = pq.poll();
                if (!visited[now]) {
                    q.add(now);
                    visited[now] = true;
                    result[now] = idx++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());

        // getSb1(reader, v, lines, start, map, visited);

    }

    // 메모리 초과
    private static void getSb1(BufferedReader reader, int v, int lines, int start, int[][] map, boolean[] visited)
            throws IOException {
        StringTokenizer st;
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = 1;
        }

        int[] result = new int[v];
        int idx = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        result[start] = idx++;
        visited[start] = true;
        while (!q.isEmpty()) {
            int now = q.poll();
            for (int i = 1; i < map[now].length; i++) {
                if (map[now][i] == 1 && !visited[i]) {
                    q.add(i);
                    visited[i] = true;
                    result[i] = idx++;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        Arrays.stream(result).forEach(value -> {
            sb.append(value);
            sb.append(System.lineSeparator());
        });
        System.out.println(sb.toString());
    }
}
