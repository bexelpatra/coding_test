package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

//자료구조는 정말 최고야
public class Baek23253 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        List<Stack<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(reader.readLine());
            st = new StringTokenizer(reader.readLine());
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < len; j++) {
                s.push(Integer.parseInt(st.nextToken()));
            }
            list.add(s);
        }
        int idx = 1;
        for (int i = 0; i < list.size(); i++) {
            pq.add(new int[] { list.get(i).pop(), i });
        }
        Stack<Integer> temp = null;
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            if (now[0] == idx++) {
                temp = list.get(now[1]);
                if (!temp.empty()) {
                    pq.add(new int[] { temp.pop(), now[1] });
                }
            } else {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
        // timeover1(reader, m, n);
    }

    private static void timeover1(BufferedReader reader, int m, int n) throws IOException {
        StringTokenizer st;
        List<Stack<Integer>> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int len = Integer.parseInt(reader.readLine());
            st = new StringTokenizer(reader.readLine());
            Stack<Integer> s = new Stack<>();
            for (int j = 0; j < len; j++) {
                s.push(Integer.parseInt(st.nextToken()));
            }
            list.add(s);
        }
        int idx = 1;
        while (idx < m) {
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                Stack<Integer> now = list.get(i);
                if (now.empty()) {
                    continue;
                }
                if (now.peek() == idx) {
                    idx += 1;
                    now.pop();
                    flag = true;
                }
            }

            if (!flag) {
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
