package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 시간초과
// 정점 개수를 5000으로 잡으니 답이 없다.
public class Baek15591 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Node>[] list = new ArrayList[5001];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        int[][] map = new int[5001][5001];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
            map[b][a] = c;
            Node node = new Node(a, b, c);
            list[a].add(node);
            list[b].add(node);
        }

        for (int mid = 0; mid < map.length; mid++) {
            for (int start = 0; start < map.length; start++) {
                for (int end = 0; end < map.length; end++) {
                    if (map[start][mid] != 0 && map[mid][end] != 0) {
                        map[start][end] = Math.min(map[start][mid], map[mid][end]);
                        Node node = new Node(start, end, map[start][end]);
                        list[start].add(node);
                        list[end].add(node);
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int k = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());

            int count = (int) list[start].stream().filter(t -> t.val >= k).count();
            sb.append(count).append("=n");
        }
        System.out.println(sb.toString());
    }

    static class Node implements Comparable<Node> {
        int a;
        int b;
        int val;

        public Node(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.val = c;
        }

        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return o.val - this.val;
        }
    }
}
