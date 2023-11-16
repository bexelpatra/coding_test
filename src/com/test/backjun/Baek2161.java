package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek2161 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Deque<Integer> dq = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            dq.add(i+1);
        }
        StringBuilder sb = new StringBuilder();

        while(dq.size()>1){
            sb.append(dq.poll()).append(" ");
            dq.add(dq.poll());
        }
        sb.append(dq.poll());

        System.out.println(sb.toString());
    }
}
