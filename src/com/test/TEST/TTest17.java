package com.test.TEST;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.TreeSet;

public class TTest17 {
    public static void main(String[] args) {
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
        map.computeIfAbsent(12, (o)->{
            return new TreeSet<>();
        });

        map.get(12).add(11239);
        map.get(12).add(1123);
        map.get(12).add(19);
        map.get(12).add(1123);
        
        map.forEach((t, u) -> System.out.println(Arrays.toString(u.toArray())));

        TreeSet<Integer> tree = new TreeSet<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int r = (int)(Math.random()*100);
            sb.append(r).append(" ");
            tree.add(r);
        }
        sb.append("\n");
        
        System.out.println(tree.last());
        
        tree.add(100);
        tree.forEach(t ->sb.append(t).append(" ") );
        System.out.println(sb.toString());
        System.out.println(tree.ceiling(99));

        String a = "12";
        String b= "12340";
        System.out.println(a.compareTo(b));
    }
}
