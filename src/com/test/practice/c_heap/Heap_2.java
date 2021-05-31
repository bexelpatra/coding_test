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

    public int solution2(int[][] jobs) {
        int answer = 0;
        PriorityQueue<int[]> list = new PriorityQueue<>((o1, o2) ->{
          if(o1[1]<o2[0]){
              return o1[1] - o2[1];
          }else {
              return -1;
          }
        } );
        for (int[] job : jobs) {
            list.add(job);
        }
        int now = 0;
        while(!list.isEmpty()){
            int[] job = list.poll();
            int req = job[0];
            int time = job[1];
            answer +=  time + (now - req);
            now +=time;
        }
        return answer/jobs.length;
    }
    public int solution3(int[][] jobs) {
        int answer = 0;

        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);

        for (int[] job : jobs) {
            queue.add(job);
        }
        int[] start = queue.poll();
        int now = start[1] + start[0];
        answer +=now;

        while(!queue.isEmpty()){
            while((queue.peek()!=null && queue.peek()[0]<=now) ||(queue.peek()!=null &&priorityQueue.isEmpty())){
                priorityQueue.add(queue.poll());
            }
            while(!priorityQueue.isEmpty()){
                int[] work = priorityQueue.poll();
                int r = work[0];
                int t = work[1];
                int sum = now - r >=0 ? now-r : 0;
                answer += t +sum;
                now += t;
            }

        }
        return answer/jobs.length;
    }
}
