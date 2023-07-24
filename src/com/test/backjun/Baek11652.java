package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Baek11652 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // getref1(reader);
        // getByPQ(reader);
        // getPq(reader);

    }

    // 나름 속도가 나올 줄 알았는데 큰 차이가 없다. getPq보다 메모리는 덜 썼지만 속도는 차이가 없다.
    private static void getByPQ(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Long.parseLong(reader.readLine()));
        }
        int max = 0;
        long now = pq.poll();
        long number = now;
        int count = 1;
        while (!pq.isEmpty()) {
            long next = pq.poll();
            if (next == now) {
                count += 1;
            } else {
                if (count >= max) {
                    max = count;
                    number = now;
                }
                count = 1;
            }
            now = next;
        }
        if (count >= max) {
            max = count;
            number = now;
        }

        System.out.println(number);
    }

    // https://www.acmicpc.net/source/48911369
    // 가장 빠르다.
    private static void getref1(BufferedReader reader) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        long[] cards = new long[n];
        for (int i = 0; i < n; i++) {
            cards[i] = Long.parseLong(reader.readLine());
        }
        Arrays.sort(cards);
        int count = 1;
        int max = 0;
        long card = 0;
        for (int i = 1; i < n; i++) {
            if (cards[i] == cards[i - 1]) {
                count += 1;
            } else {
                if (count > max) {
                    max = count;
                    card = cards[i - 1];
                }
                count = 1;
            }
        }
        System.out.println(count > max ? cards[n - 1] : card);
    }

    private static void getPq(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        Map<String, Integer> map = new HashMap<>();

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[1]) {
                return Long.compare(o1[0], o2[0]);
            } else {
                return Long.compare(o2[1], o1[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            String number = reader.readLine();
            Integer now = map.getOrDefault(number, 0) + 1;
            map.put(number, now);
        }

        for (String key : map.keySet()) {
            pq.add(new long[] { Long.parseLong(key), map.getOrDefault(key, 0) });
        }
        System.out.println(pq.poll()[0]);
    }
}
