package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek3986 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // getByStack();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            char[] word = reader.readLine().toCharArray();
            char[] rest = new char[word.length];
            int idx = 0;
            for (int j = 0; j < word.length; j++) {
                if (idx == 0) {
                    rest[idx] = word[j];
                    idx += 1;
                } else if (rest[idx - 1] == word[j]) {
                    idx -= 1;
                } else {
                    rest[idx] = word[j];
                    idx += 1;
                }
            }
            if (idx == 0) {
                count += 1;
            }
        }
        System.out.println(count);
    }

    private static void getByStack() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Stack<Character> stack;
        int count = 0;
        for (int i = 0; i < n; i++) {

            char[] now = reader.readLine().toCharArray();
            stack = new Stack<>();
            stack.add(now[0]);
            for (int j = 1; j < now.length; j++) {
                if (!stack.isEmpty()) {
                    char a = stack.peek();
                    if (a == now[j]) {
                        stack.pop();
                    } else {
                        stack.add(now[j]);
                    }
                } else {
                    stack.add(now[j]);
                }
            }
            if (stack.isEmpty()) {
                count++;
            }
        }
        System.out.println(count);
    }
}
