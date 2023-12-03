package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = reader.readLine();
        Stack<Character> stack = new Stack<>();
        int count = 0;
        boolean laser = false;
        for (char c : temp.toCharArray()) {
            if(c=='('){
                stack.add(c);
                laser = true;
            }else{ // 닫힘인데 레이저인지 아닌지 알아야 한다.
                stack.pop();
                if(laser){ // 레이저인 경우
                    laser = false;
                    count += stack.size();
                }else{ // 쇠막대기 끝자락
                    count+=1;
                }
            }
        }
        System.out.println(count);
    }
}
