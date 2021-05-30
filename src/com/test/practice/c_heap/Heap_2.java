package com.test.practice.c_heap;
import java.util.*;
public class Heap_2 {
    public int solution(int[][] jobs) {
        int answer = 0;
        List<int[]> list = new ArrayList<>();
        for (int[] job : jobs) {
            list.add(job);
        }
        list.sort((o1, o2) -> o1[0]-o2[0]);
        int time = 0;
        int start = list.get(0)[0];
        int finish = list.get(0)[1] + list.get(0)[0];
        time = finish;
        for(int i=1;i<list.size();i++){
            int[] a = list.get(i);
        }
        return answer;
    }
}
