package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1461 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] books = new int[n];
        st = new StringTokenizer(reader.readLine());
        List<Integer> possitive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();
        for (int i = 0; i < books.length; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if (books[i] < 0) {
                negative.add(books[i] * -1);
            } else {
                possitive.add(books[i]);
            }
        }
        possitive.sort(Comparator.reverseOrder());
        negative.sort(Comparator.reverseOrder());

        possitive.add(0);
        negative.add(0);
        // if (possitive.size() > 0) {
        // po = possitive.get(0);
        // }
        // if (negative.size() > 0) {
        // ne = negative.get(0);
        // }
        int max = Math.max(possitive.get(0), negative.get(0));
        int result = 0;
        for (int i = 0; i < possitive.size(); i += m) {
            result += possitive.get(i) * 2;
        }
        for (int i = 0; i < negative.size(); i += m) {
            result += negative.get(i) * 2;
        }
        result -= max;
        System.out.println(result);
        // getNow(reader);
    }

    private static void getNow(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] books = new int[n];
        st = new StringTokenizer(reader.readLine());
        PriorityQueue<Integer> possitive = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> negative = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < books.length; i++) {
            books[i] = Integer.parseInt(st.nextToken());
            if (books[i] < 0) {
                negative.add(books[i] * -1);
            } else {
                possitive.add(books[i]);
            }
        }
        int result = 0;

        int count = 0;
        int po = possitive.peek() == null ? 0 : possitive.peek();
        int ne = negative.peek() == null ? 0 : negative.peek();
        boolean flag = po > ne; // 양수가 크다.

        while (!possitive.isEmpty()) {
            int now = possitive.poll();

        }
        while (!negative.isEmpty()) {

        }
    }
}
