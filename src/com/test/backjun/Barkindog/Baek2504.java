package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// 마지막에 스택에 남아있는 값이 있는지 반드시 확인해야 한다.
public class Baek2504 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();

        long count = 0;
        // (()[[][]])([])
        Stack<Character> stack = new Stack<>();
        int idx =1;
        boolean flag = false;
        for (char c : temp.toCharArray()) {
            if(c=='('){
                idx *=2;
                flag=true;
                stack.add(c);
            }else if(c=='['){
                idx *=3;
                flag=true;
                stack.add(c);
            }else if(c==')'){
                if(stack.empty() || stack.peek()!='('){
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(flag){
                    count += idx;
                    flag= false;
                }
                idx /=2;
            }else if(c==']'){
                if(stack.empty() || stack.peek()!='['){
                    System.out.println(0);
                    return;
                }
                stack.pop();
                if(flag){
                    count += idx;
                    flag= false;
                }
                idx /=3;
            }
        }
        if(!stack.isEmpty()){
            System.out.println(0);
            return;
        }
        System.out.println(count);
    }
}
