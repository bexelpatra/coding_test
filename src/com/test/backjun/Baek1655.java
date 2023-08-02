package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class Baek1655 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // getLinkedList(reader);
        // getDoublePq(reader);
    }

    // 시간 초과
    private static void getLinkedList(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        List<Integer> list = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            int idx = divide(list, i, now);

            list.add(idx, now);
            sb.append(list.get(i / 2));
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static void getDoublePq(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        // getSol1(reader, n);
        PriorityQueue<Integer> natural = new PriorityQueue<>(Comparator.naturalOrder()); // 큰애들
        PriorityQueue<Integer> reverse = new PriorityQueue<>(Comparator.reverseOrder()); // 작은 애들
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            if (natural.size() == reverse.size()) {
                reverse.add(now);
            } else {
                natural.add(now);
            }
            if (!natural.isEmpty() && !reverse.isEmpty() && natural.peek() < reverse.peek()) {
                int temp = natural.poll();
                natural.add(reverse.poll());
                reverse.add(temp);
            }
            sb.append(reverse.peek());
            sb.append(System.lineSeparator());
            // System.out.println(Arrays.toString(reverse.toArray()) +
            // Arrays.toString(natural.toArray()));
        }
        System.out.println(sb.toString());
    }

    // 시간 초과
    private static void getSol1(BufferedReader reader, int n) throws IOException {
        int[] arr = new int[n];
        arr[0] = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append(arr[0]);
        sb.append(System.lineSeparator());
        for (int i = 1; i < arr.length; i++) {
            int now = Integer.parseInt(reader.readLine());
            int idx = divide(arr, i, now);
            arrBackward(arr, idx, i);

            arr[idx] = now;
            sb.append(arr[i / 2]);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }

    private static int divide(int[] arr, int index, int my) {
        int lo = 0;
        int hi = index;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (arr[mid] < my) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static <E> int divide(List<E> arr, int index, int my) {
        int lo = 0;
        int hi = index;
        while (lo < hi) {
            int mid = (hi + lo) / 2;
            if (Integer.parseInt(arr.get(mid).toString()) < my) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    private static int[] arrBackward(int[] arr, int s, int e) {
        for (int i = e; i > s; i--) {
            arr[i] = arr[i - 1];
        }
        return arr;
    }
}
