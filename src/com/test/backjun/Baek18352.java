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

public class Baek18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        List<int[]>[] list = new List[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(new int[] { to, 1 });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[] { start, 0 });
        int[] weight = new int[n + 1];
        Arrays.fill(weight, Integer.MAX_VALUE);

        weight[start] = 0;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int num = now[0];
            if (!visited[num]) {
                visited[num] = true;
                list[num].forEach(t -> {
                    if (!visited[t[0]] && weight[t[0]] > t[1] + weight[num]) {
                        weight[t[0]] = t[1] + weight[num];
                        pq.add(new int[] { t[0], weight[t[0]] });
                    }
                });
            }
        }

        StringBuilder sb = new StringBuilder();
        // System.out.println(Arrays.toString(weight));

        for (int i = 0; i < weight.length; i++) {
            if (weight[i] == target) {
                sb.append(i).append("\n");
            }
        }
        if (sb.length() == 0) {
            sb.append(-1);
        }
        System.out.println(sb.toString());
        // getSb(reader);
    }

    static class point {
        public int from;
        public int to;
        public int val;

        point(int from, int to, int val) {
            this.from = from;
            this.to = to;
            this.val = val;
        }

    }

    private static void getSb(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n + 1];
        List<Integer>[] list = new List[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            list[from].add(to);
        }

        // Deque<Integer> q = new ArrayDeque<>();
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        list[start].forEach(t -> {
            q.add(t);
        });
        int idx = 0;
        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) {
            idx += 1;
            List<Integer> temp = new ArrayList<>();
            while (!q.isEmpty()) {
                int now = q.poll();
                temp.add(now);
            }
            if (idx == target) {
                temp.stream().sorted().forEach(t -> {
                    if (!visited[t]) {
                        sb.append(t).append("\n");
                    }
                });
                System.out.println(sb.toString());
                return;
            } else {
                temp.stream().forEach(t -> {
                    if (!visited[t]) {
                        visited[t] = true;
                        list[t].forEach(t2 -> q.add(t2));
                    }
                });
            }

        }
        System.out.println(-1);
    }
}
