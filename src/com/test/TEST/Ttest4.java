package com.test.TEST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// 객체의 참조
public class Ttest4 {
    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<>();
        map.put("outter", 14);
        System.out.println(map.hashCode());

        System.out.println((map = ref(map)).hashCode());
        System.out.println(map.hashCode());

        System.out.println((int) Math.sqrt(101));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println(pq.peek());
        List<Integer> list = new ArrayList<>();
        System.out.println(list.get(0));
    }

    public static Map ref(Map<String, Object> map) {
        map.put("inner", 123);
        System.out.println(map.hashCode());
        return map;
    }
}
