package com.test.practice.b_stack_queue;

import java.util.*;

public class StackQueue_1 {

    /*
        프로그래머스에서 다른사람이 풀은 방식, array를 사용하는 방식이 흥미롭다.
     */

//    int[] p = new int[]{95, 90, 99, 99, 80, 99};
//    int[] s = new int[]{1, 1, 1, 1, 1, 1};

    public int[] solution_programmers(int[] progresses, int[] speeds) {
        int[] dayOfend = new int[100];
        int day = -1;
        for(int i=0; i<progresses.length; i++) {
            while(progresses[i] + (day*speeds[i]) < 100) {
                day++;
            }
            dayOfend[day]++;
        }
        return Arrays.stream(dayOfend).filter(i -> i!=0).toArray();
    }
    /*
        deque를 사용해서 풀어보려고 시도 중.
     */
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<progresses.length;i++){
            double remain = (100 - progresses[i]) / speeds[i];
            deque.add((int)Math.ceil(remain));
        }
        while(deque.size()!=0){
            if(deque.peek()!=null){
                int standard = deque.pollFirst();
            }
        }
        return answer;
    }

    /*
        단순한 반복문을 이용해서 해결해보았다.
     */
    public int[] solution2(int[] progresses, int[] speeds) {

        List<Integer> ans = new ArrayList<>();
        int day = 0;
        int deploy = 1;

        for(int i=0; i< progresses.length;i++){
            progresses[i] += day*speeds[i];
            if(progresses[i]>=100){
                deploy++;
            }else {
                while(progresses[i]<100){
                    progresses[i] += speeds[i];
                    day++;
                }
                if(i!=0) {
                    ans.add(deploy);
                    deploy=1;
                }
            }
        }
        ans.add(deploy);

        int[] answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            answer[i] = ans.get(i);
        }
        return answer;
    }

    /*
        deque를 이용한 풀이
        double end queue
        사용하기에 따라서 que와 stack 처럼 사용이 가능하다
        push = addFirst
        add = addLast

        FIFO방식
        poll = pop = pollFirst

        LIFO방식
        pollLast
     */
    public int[] solution3(int[] progresses, int[] speeds) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i=0; i<progresses.length;i++){
            double remain = (100-progresses[i])/speeds[i];
            deque.add((int)Math.ceil(remain));
        }
        int standard = deque.poll();
        int deploy = 1;

        List<Integer> list = new ArrayList<>();
        while(!deque.isEmpty()){
            int current = deque.poll();
            if(standard>=current){
                deploy++;
            } else {
                list.add(deploy);
                deploy =1;
                standard = current;
            }
        }
        list.add(deploy);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

}
