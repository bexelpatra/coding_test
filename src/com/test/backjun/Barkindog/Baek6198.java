package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek6198 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] buildings = new int[n];
        Stack<Integer> stack = new Stack<>();
        long cnt = 0;
        for (int i = 0; i < buildings.length; i++) {
            int now = Integer.parseInt(reader.readLine());
            while (!stack.empty() && stack.peek() <= now) {
                stack.pop();
            }
            cnt += stack.size();
            stack.add(now);
        }

        System.out.println(cnt);
    }
}
