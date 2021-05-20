package com.test.practice.stack_queue;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StackQueue_2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> priorityList = new ArrayList<>();
        Deque<Integer> deque = new ArrayDeque<>();
        for (int priority : priorities) {
            priorityList.add(priority);
            deque.add(priority);
        }
        int size = priorities.length;
//        if(location!=0){
//            for(int i=0;i<location;i++){
//                deque.add(deque.pop());
//            }
//        }
        priorityList.sort((o1, o2) -> o2-o1);
        List<Integer> list = new ArrayList<>();

        int i=0;
        int k=0;
        int max = priorityList.get(k);
        while (list.size() != size){
//        for(int i=0; i <priorityList.size();i++){
            int now = deque.pop();
            if(max == now){
                max = priorityList.get(k+=1);
            }else {
                deque.add(now);
            }
                i++;
        }
        for(int j=0; j<priorityList.size();j++){
            if(priorityList.get(j) == location) return j;
        }
        return answer;
    }

    /*
        인터넷을 참조
     */
    public int solution2(int[] priorities, int location) {
        int answer = 0;
        Queue<Printer> q = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) { // print큐에 인덱스번호, 우선순위 삽입
            q.offer(new Printer(i, priorities[i]));
        }

        while (!q.isEmpty()) {

            boolean flag = false;
            int com = q.peek().prior;
            for (Printer p : q) {
                if (com < p.prior) { // 맨앞의 수보다 큰 숫자가 존재하면
                    flag = true;
                }
            }

            if (flag) {
                q.offer(q.poll());
            } else {// 현재 맨앞의 숫자가 가장 클 때
                if (q.poll().location == location) {
                    answer = priorities.length - q.size();
                }
            }
        }
        return answer;
    }
    class Printer {
        //
        int location;
        int prior;

        Printer(int location, int prior) {
            this.location = location;
            this.prior = prior;
        }
    }
}
