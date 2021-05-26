package com.test.practice.stack_queue;

import java.util.Stack;

public class StackQueue_4 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int first = prices[i];
            int ans = 0;
            for(int j= i+1;j<prices.length;j++){
                if(first<=prices[j]) {
                    ans++;
                }
            }

            answer[i] = ans;
        }
        return answer;
    }
    public int[] solution1(int[] prices) {
        Stack<Integer> beginIdxs = new Stack<>();
        int i=0;
        int[] terms = new int[prices.length];
        // 시작점
        beginIdxs.push(i);
        for (i=1; i<prices.length; i++) {
            // 인덱스가 비어있지 않고(while문을 벗어나기 위해서), 현재 시점과 스택에 들어간 시점의 값을 빼서 주가가 떨어지지 않은 시간을구한다.
            while (!beginIdxs.empty() && prices[i] < prices[beginIdxs.peek()]) {
                int beginIdx = beginIdxs.pop();
                terms[beginIdx] = i - beginIdx;
            }
            beginIdxs.push(i);
        }
        while (!beginIdxs.empty()) {
            int beginIdx = beginIdxs.pop();
            terms[beginIdx] = i - beginIdx - 1;
        }

        return terms;
    }
}
