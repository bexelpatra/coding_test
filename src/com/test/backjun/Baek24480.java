package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek24480 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < v + 1; i++) {
            list.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }
        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int[] result = new int[v + 1];
        dfs(list, result, new boolean[v + 1], start);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i])
                    .append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    static int idx = 1;

    public static void dfs(List<PriorityQueue<Integer>> list, int[] result, boolean[] visited, int start) {
        result[start] = idx++;
        visited[start] = true;
        PriorityQueue<Integer> pq = list.get(start);
        while (!pq.isEmpty()) {
            int next = pq.poll();
            if (!visited[next]) {

                dfs(list, result, visited, next);
            }
        }
    }

}
