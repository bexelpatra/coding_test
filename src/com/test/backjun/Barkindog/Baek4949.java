package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
        String temp = "";
        StringBuilder sb = new StringBuilder();
        while(!(temp= reader.readLine()).equals(".")){
            boolean flag = true;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i)=='('){
                    stack.add('(');
                }else if(temp.charAt(i)=='['){
                    stack.add('[');
                }else if(temp.charAt(i)==')'){
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        if(stack.pop() != '('){
                            flag = false;
                            break;
                        }
                    }
                }else if(temp.charAt(i)==']'){
                    if(stack.isEmpty()){
                        flag = false;
                        break;
                    }else{
                        if(stack.pop() != '['){
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if(flag && stack.isEmpty()){
                sb.append("yes").append("\n");
            }else {
                sb.append("no").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
