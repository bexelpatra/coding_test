package com.test.TEST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TTest13 {
    public static void main(String[] args) {
        String temp = "1234";
        int x = 123;
        ;
        System.out.println(Integer.toString(3333, 4));
        System.out.println("왜 안나옴?");
        System.out.println((char) ('\307'));

        System.out.println((char) ('\003'));
        System.out.println((char) ('\020'));
        System.out.println((char) ('\001'));
        System.out.println((char) ('\032'));
        Deque<Integer> dq = new ArrayDeque<>();

        Integer[] i = new Integer[3];
        ;
        int[][] arr = new int[4][2];
        System.out.println(Arrays.toString(i));

        for (int j = 0; j < arr.length; j++) {
            System.out.println(Arrays.toString(arr[j]));
        }
        // combi(new int[3], new boolean[arr.length], 0, 0);

        int[][] map = new int[3][3];
        int idx = 0;
        for (int j = 0; j < map.length; j++) {
            for (int j2 = 0; j2 < map.length; j2++) {
                map[j][j2] = idx ++;
            }
        }
        int[] replace = new int[]{99,99,99};
        map[1] = replace;
        // replace = null;
        replace=new int[]{-1,-1,-1};
        print(map);
        print(map);
    }

    static int[] arr = new int[] { 1, 2, 3, 4, 5, 6 };
    public static void print(int[][]map){
        for (int[] js : map) {
            System.out.println(Arrays.toString(js));
        }
    }
    public static void combi(int[] result, boolean[] visited, int idx, int start) {
        if (idx == result.length) {
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                result[idx] = arr[i];
                combi(result, visited, idx + 1, i + 1);
                visited[i] = false;
            }
        }
    }
}
