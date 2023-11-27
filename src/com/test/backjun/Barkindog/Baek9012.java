package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek9012 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String temp = reader.readLine();
            Stack<Character> stack = new Stack<>();
            boolean flag = true;
            for (char c : temp.toCharArray()) {
                if(c == '('){
                    stack.add('(');
                }else{
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        if(stack.peek() == '('){
                            stack.pop();
                        }
                    }
                }
            }
            if(!stack.empty()){
                flag = false;
            }
            if(flag){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
