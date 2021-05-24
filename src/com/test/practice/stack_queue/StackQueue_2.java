package com.test.practice.stack_queue;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class StackQueue_2 {
    /*
    일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다. 이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때, 내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
     */
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
