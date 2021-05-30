package com.test.practice.c_heap;

import java.util.*;
import java.util.stream.Collectors;

public class Heap_3 {
    public int[] solution(String[] operations) {

        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        int size = 0;
        for (String operation : operations) {
            if (operation.startsWith("I")) {
                int number = Integer.parseInt(operation.substring(2, operation.length()));

                minQue.add(number);
                maxQue.add(number);
                size++;
            } else if (operation.equals("D 1")) { // 최댓값 삭제
                if(size>0) {
                    maxQue.poll();
                    size--;
                }
            } else if (operation.equals("D -1")) { // 최솟값 삭제
                if(size>0){
                    minQue.poll();
                    size--;
                }
            }
            if(size==0){
                maxQue.clear();
                minQue.clear();
            }
        }

        if(size == 0){
            return new int[]{0,0};
        }else if(size ==1 ){
            int a = minQue.poll();
            return new int[]{a,a};
        }else{
            return new int[]{maxQue.poll(),minQue.poll()};
        }
    }
}
