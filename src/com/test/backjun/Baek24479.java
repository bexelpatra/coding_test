package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek24479 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int vertex = Integer.parseInt(st.nextToken());
        int lines = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        List<PriorityQueue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < vertex + 1; i++) {
            list.add(new PriorityQueue<>());
        }

        for (int i = 0; i < lines; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == start || b == start) {

                list.get(a).add(b);
                list.get(b).add(a);
            }
        }
        boolean[] visited = new boolean[vertex + 1];
        int[] result = new int[vertex + 1];

        visited[start] = true;
        result[start] = index++;
        dfs(list, visited, start, result);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    static int index = 1;

    private static void dfs(List<PriorityQueue<Integer>> list, boolean[] visited, int start, int[] result) {
        PriorityQueue<Integer> pq = list.get(start);
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (!visited[now]) {
                visited[now] = true;
                result[now] = index++;
                dfs(list, visited, now, result);
            }
        }
    }

    private static void getStack(int start, List<PriorityQueue<Integer>> list, boolean[] visited, int[] result,
            int idx) {
        Stack<Integer> stack = new Stack<>();
        stack.add(start);

        while (!stack.isEmpty()) {
            int now = stack.pop();
            PriorityQueue<Integer> temp = list.get(now);
            if (!visited[now]) {
                visited[now] = true;
                result[now] = idx++;
            }
            while (!temp.isEmpty()) {
                int next = temp.poll();
                if (!visited[next]) {
                    stack.push(next);
                    break;
                }
            }
        }
    }

}
