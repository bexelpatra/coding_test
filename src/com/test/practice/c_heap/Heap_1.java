package com.test.practice.c_heap;

import org.junit.Test;

import java.util.PriorityQueue;

public class Heap_1 {
    // 이건 실패
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

    public int solution2(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int scov : scoville) q.add(scov);
        while(true){
            int now = q.poll();
            if(now >= K) break;
            if(q.peek() == null) {
                answer = -1;
                break;
            }
            answer++;
            q.add(mix(now,q.poll()));
        }
        return answer;
    }

    public int mix(int a, int b){
        int sum =0;
        if(a>b) {
            sum = a * 2 + b;
        }else{
            sum = a+ b*2;
        }
        return sum;
    }
    @Test
    public void test(){

    }
}
