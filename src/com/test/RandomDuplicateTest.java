package com.test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class RandomDuplicateTest {
    private static ConcurrentMap<String, Object> map2;

    public static void main(String[] args) {
        if (map2 == null) {
            map2 = new ConcurrentHashMap<>();
        }
        int i = 0;
        double now = 0;
        int x = 1000000;
        System.out.println(String.format("%6d", x));
        System.out.println(Thread.currentThread().getName());
        while (i < 100) {
            System.out.println(getSeq());
            i += 1;
        }
        // try {
        // Set<Double> set = new HashSet<>(100_000_000); // 10억
        // while (set.size() == i) {
        // now = Math.random();
        // System.out.println(i);
        // set.add(now);
        // i += 1;
        // }
        // System.out.println(now);
        // System.out.println(i);

        // } catch (Exception e) {
        // // TODO: handle exception
        // System.out.println(now);
        // System.out.println(i);
        // }

    }

    private static String getSeq() {
        int temp = Integer.parseInt(map2.getOrDefault("seq", "0").toString());
        map2.put("seq", temp + 1);
        temp %= 1_000_000;
        String result = String.format("%06d", temp);
        return result;
    }
}
