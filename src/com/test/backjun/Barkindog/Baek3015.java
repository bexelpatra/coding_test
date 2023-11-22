package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 다시 풀어볼 것...
/*
 * 1. stack까지는 떠올리지만 구현에서 막히는 경우가 종종 있다.
 * 2. stack이 아닌 array로 구현해서 속도와 메모리를 절약하는 방식에 대한 이해 필요.
 */
public class Baek3015 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Stack<int[]> stack = new Stack<>();
        
        int count = 0;

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(reader.readLine());
            int[] now = new int[]{temp,1};
            while (!stack.isEmpty() && stack.peek()[0] <= now[0]) {
                int[] next = stack.pop();
                count += next[1];
                if(next[0] == now[0]){
                    now[1] += next[1];
                }
            }
            if(!stack.isEmpty()){
                count+=1;
            }
            stack.add(now);
        }

        System.out.println(count);
        
    }
}
