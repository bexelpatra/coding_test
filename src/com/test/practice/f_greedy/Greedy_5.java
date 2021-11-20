package com.test.practice.f_greedy;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Greedy_5 {
    public class Island{
        private int a;
        private int b;
        private int price;

        public Island(int a, int b, int price) {
            if( a > b) {
                int c = b;
                b = a;
                a = c;
            }
            this.a = a;
            this.b = b;
            this.price = price;
        }

        public int getA() { return a; }public int getB() { return b; }public int getPrice() { return price; }
    }
    public int solution(int n, int[][] costs) {
        int answer = 0;
        List<Island> islandList = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        for (int[] cost : costs) {
            islandList.add(new Island(cost[0],cost[1],cost[2]));
        }
        islandList = islandList.stream().sorted(Comparator.comparing(Island::getPrice)).collect(Collectors.toList());
        for (Island island : islandList) {
            if(integers.contains(island.a))
            integers.add(island.a);
            integers.add(island.b);


        }

        return answer;
    }

    @Test
    public void test(){

    }
}
