package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

// 자료구조 : 탑
public class Baek2493 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] tops = new int[n];
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < result.length; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        stack.push(n - 1);
        for (int i = n - 2; i >= 0; i--) {
            while (!stack.isEmpty()) {
                int now = stack.pop();
                if (tops[i] >= tops[now]) {
                    result[now] = i + 1;
                } else {
                    stack.add(now);
                    break;
                }
            }
            stack.push(i);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
            sb.append(' ');
        }
        System.out.println(sb.toString());
        // getSb(reader);

    }

    // 메모리 초과...
    private static void getSb(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int[] tops = new int[n + 1];
        int[] result = new int[n + 1];
        tops = new int[n + 1];
        result = new int[n + 1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < n + 1; i++) {
            tops[i] = Integer.parseInt(st.nextToken());
        }
        Queue<Integer> q = new ArrayDeque<>();
        q.add(n);
        for (int i = n - 1; i > 0; i--) {
            check(q, result, tops, i);
            q.add(i);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < result.length; i++) {
            sb.append(result[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    public static void check(Queue<Integer> q, int[] result, int[] tops, int idx) {
        if (idx == 0) {
            return;
        }
        int size = q.size();
        for (int i = 0; i < size; i++) {
            int tempIndex = q.poll();
            if (tops[idx] >= tops[tempIndex]) {
                result[tempIndex] = idx;
            } else {
                q.add(tempIndex);
            }
        }

    }
}
