package com.test.TEST;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class TTest8 {
    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("%d\n");
        System.out.printf(sb.toString(),123);


        Deque<Integer> dq = new ArrayDeque<>();
        add(dq);
        System.out.println(dq.size());

        StringTokenizer st = new StringTokenizer("0 1");
    
        System.out.println(st.countTokens());
        System.out.println(st.nextToken());

        int x = 0;
        int y = 0;
        System.out.println(--x ==-1);
        System.out.println(x-- == -1);
        System.out.println(x);
    }

    public static void add(Deque<Integer> dq){
        dq.add(123);
        dq.add(123);
        dq.add(123);
        dq.add(123);
    }
}
