package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek2493 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // 높이와 위치
        Stack<int[]> stack = new Stack<>();

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int h = Integer.parseInt(st.nextToken());
            int[] now = new int[]{h,i+1};
            while(!stack.isEmpty() && stack.peek()[0] < h){
                stack.pop();
            }
            if(!stack.empty()){
                int[]  got  = stack.peek();
                arr[i] = got[1];
            }
            stack.add(now);
        }
        StringBuilder sb = new StringBuilder();
        for (int i : arr) {
            sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
