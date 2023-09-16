package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 2023-09-17 실패
 * leaf 에서 leaf로 가는 것을 모두 찾으면 될거라고 생각했다. -> 반례 리프에서 루트까지가 가장 비용이 클 수도 있다
 * 메모리 초과
 */
public class Baek1967 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        tree = new int[n + 1][n + 1];
        StringTokenizer st = null;
        leaf = new boolean[n + 1];
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            tree[from][to] = val;
            tree[to][0] = from;
            leaf[from] = true;
        }

        for (int i = 0; i < leaf.length; i++) {
            int temp = 0;
            if (!leaf[i]) {
                int upper = tree[i][0];
                int nowNode = i;
                while (upper != 0) {
                    System.out.printf("leaf : %d , upper : %d temp : %d val : %d \n", i, upper,
                            temp, tree[upper][nowNode]);

                    temp += tree[upper][nowNode];
                    // 밑으로 내려가는 중
                    for (int j = nowNode + 1; j < tree[upper].length; j++) {
                        if (tree[upper][j] != 0) {
                            down(upper, j, temp);
                        }
                    }
                    nowNode = upper;
                    upper = tree[upper][0];
                }
            }
        }
        System.out.println(maxInt);
    }

    static int[][] tree;
    static boolean[] leaf;
    static int maxInt = 0;

    public static void down(int node, int idx, int val) {
        if (!leaf[node]) {
            System.out.printf("down => node : %d idx : %d val : %d\n", node, idx, val);
            maxInt = Math.max(maxInt, val);
            return;
        }
        for (int i = idx; i < tree[node].length; i++) {
            if (tree[node][i] != 0) {
                down(i, i, val + tree[node][i]);
            }
        }
    }
}
