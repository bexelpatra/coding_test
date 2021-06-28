package com.test.practice.z_test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Test {
//    [[1, 4], [3, 4], [3, 10]]
    public int[] solution(int[][] v) {
        int[] answer = {};
        int commax = 0;
        int commay = 0;
        Map<Integer, Long> x = Arrays.stream(v).map(ints -> ints[0]).collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));
        Map<Integer, Long> y = Arrays.stream(v).map(ints -> ints[1]).collect(Collectors.groupingBy(Integer::intValue,Collectors.counting()));

        commax = (x.keySet().stream().filter(integer -> x.get(integer) !=2l).findFirst().orElse(0));
        commay = (y.keySet().stream().filter(integer -> y.get(integer) !=2l).findFirst().orElse(0));
        answer = new int[]{commax,commay};

        System.out.println(String.format("[%d,%d]",commax,commay));
        return answer;
    }
}
