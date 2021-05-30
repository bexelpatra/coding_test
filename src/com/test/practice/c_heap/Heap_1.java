package com.test.practice.c_heap;

import java.util.PriorityQueue;

public class Heap_1 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue();
        for (int i : scoville) {
            priorityQueue.add(i);
        }

        while(!priorityQueue.isEmpty()){
            int first = priorityQueue.poll();
            if(first>=K){
                return answer;
            }
            if(priorityQueue.isEmpty()){
                if(first<K){
                    return -1;
                }else {
                    return 0;
                }
            }
            int second = priorityQueue.poll();
            int sum = first+ second*2;
            answer++;
            priorityQueue.add(sum);
        }
        return answer;
    }

}
