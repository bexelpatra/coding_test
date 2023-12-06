package com.test.TEST;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TTest14 {
    public static void main(String[] args) {
        int b = 0;
        int idx = 0;
        int[] arr = new int[5];
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(8);
        dq.add(8);
        dq.add(4);
        dq.add(4);
        if (dq.size() > 0) {
            int start = -1;
            if (b % 2 == 0) {// 역방
                start = dq.pollLast();
                idx = arr.length - 1;
                arr[idx] = start;
                while (!dq.isEmpty()) {
                    int now = dq.pollLast();
                    if (start == now) {
                        arr[idx] *= 2;
                        start = arr[idx];
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
                        start = arr[idx];
                    } else {
                        arr[idx + 1] = now;
                        start = arr[idx + 1];
                        idx += 1;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }
}
