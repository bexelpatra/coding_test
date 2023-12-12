package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/*
    실패 기록
    
    try 1
    1. 움직이고 마지막 자리에서 검사하지 않아서 -1을 남김
    2. 움직이려는 줄과 방향에 따라서 trim 처리하면서 진행해볼 예정

    try 2
    1. trim 부분에서 한꺼번에 다 합쳐져 버린다. 1회분만 합쳐져야지만 한다.

 */
public class Baek12100_2 {
    static int map[][];
    static int origin[][];
    static long max = -1;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        origin = new int[n][n];
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, origin[i][j]);
            }
        }
        copyOrigin();
        recur(new int[5], 0);

        System.out.println(max);
    }
    // 0 우 1 하 2 좌 3 상
    static FileOutputStream os;
    static int[] directions = { 0, 1, 2, 3 };

    public static void recur(int[] order, int idx) {
        if (idx == order.length) {
            for (int i : order) {
                move(i);
            }
            copyOrigin();
            return;
        }
        for (int i = 0; i < directions.length; i++) {
            order[idx] = directions[i];
            recur(order, idx + 1);
        }
    }

    public static void copyOrigin() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = origin[i][j];
            }
        }
    }

    public static void trim(int y, int x, int a) {
        int len = map.length;
        int[] arr = new int[len];
        Deque<Integer> dq = new LinkedList<>();
        if (a % 2 == 0) { // x축 수정 0 좌, 2 우
            for (int i : map[y]) {
                if (i != 0) {
                    dq.add(i);
                }
            }
        } else { // y축 수정 1 상, 3 하
            for (int i = 0; i < len; i++) {
                if (map[i][x] != 0) {
                    dq.add(map[i][x]);
                }
            }
        }

        int idx = 0;
        if (dq.size() > 0) {
            int start = -1;
            if (a < 2) {// 역방
                start = dq.pollLast();
                idx = len - 1;
                arr[idx] = start;
                while (!dq.isEmpty()) {
                    int now = dq.pollLast();
                    if (start == now) {
                        arr[idx] *= 2;
                        // start = arr[idx];
                        start = 0;
                        max = Math.max(arr[idx], max);
                    } else {
                        arr[idx - 1] = now;
                        start = arr[idx - 1];
                        idx -= 1;
                    }
                }
            } else { // 정방
                start = dq.pollFirst();
                arr[idx] = start;
                while (!dq.isEmpty()) {
                    int now = dq.pollFirst();
                    if (start == now) {
                        arr[idx] *= 2;
                        // start = arr[idx];
                        start = 0;
                        max = Math.max(arr[idx], max);
                    } else {
                        arr[idx + 1] = now;
                        start = arr[idx + 1];
                        idx += 1;
                    }
                }
            }
        }
        if (a % 2 == 0) {
            map[y] = arr;
        } else {
            for (int i = 0; i < arr.length; i++) {
                map[i][x] = arr[i];
            }
        }
    }

    public static void move(int a) {
        int len = map.length;
        if(a%2==0){ //  좌우
            for (int i = 0; i < len; i++) {
                trim(i, 0, a);
            }
        }else{ // 상하
            for (int i = 0; i < len; i++) {
                trim(0, i, a);
            }
        }
    }
}
