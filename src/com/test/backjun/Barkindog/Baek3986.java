package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek3986 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            String temp = reader.readLine();
            for (int j = 0; j < temp.length(); j++) {
                if(stack.isEmpty()){
                    stack.add(temp.charAt(j));
                }else{
                    if(stack.peek() == temp.charAt(j)){
                        stack.pop();
                    }else{
                        stack.add(temp.charAt(j));
                    }
                }
            }
            if(stack.isEmpty()){
                count+=1;
                // sb.append("yes").append("\n");
            }else{
                // sb.append("no").append("\n");
            }
        }
        System.out.println(count);
    }
}
