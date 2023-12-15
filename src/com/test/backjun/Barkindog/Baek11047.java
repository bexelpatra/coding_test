package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            if(now <=m){
                stack.add(now);
            }
        }
        int count = 0;
        while(!stack.isEmpty() || m!=0){
            int now = stack.pop();
            count += m/now;
            m = m %now;
        }
        System.out.println(count);
    }
}
