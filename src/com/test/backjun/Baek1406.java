package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek1406 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        
        Stack<String> front = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            front.add(String.valueOf(line.charAt(i)));
        }
        Stack<String> back = new Stack<>();
        String temp = "";
        while(n-->0){
            st = new StringTokenizer(reader.readLine());
            temp = st.nextToken();
            if("L".equals(temp)){
                if(!front.isEmpty()){
                    back.add(front.pop());
                }
            }else if("D".equals(temp)){
                if(!back.isEmpty()){
                    front.add(back.pop());
                }
            }else if("B".equals(temp)){
                if(!front.isEmpty()){
                    front.pop();
                }
            }else if("P".equals(temp)){
                front.add(st.nextToken());
            }
        }
        StringBuilder f= new StringBuilder();
        StringBuilder b= new StringBuilder();
        while(!front.isEmpty()){
            f.append(front.pop());
        }
        while(!back.isEmpty()){
            b.append(back.pop());
        }
        
        System.out.println(f.reverse().append(b).toString());
    }
}
