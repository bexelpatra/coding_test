package com.test.practice.b_stack_queue;

import java.util.Stack;

public class StackQueue_4 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i=0;i<prices.length;i++){
            int first = prices[i];
            int ans = 0;
            for(int j= i+1;j<prices.length;j++){
                ans++;
                if(first>prices[j]) {
                    break;
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

    public int[] solution2(int[] prices) {
        int[] terms = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        stack.add(0);
        for(int i=1; i< prices.length;i++){
            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]){
                int index = stack.pop();
                terms[index] = i - index;
            }
            stack.push(i);
        }
        while(!stack.isEmpty()){
            int index = stack.pop();
            terms[index] = prices.length - index - 1;
        }

        return terms;
    }
}
