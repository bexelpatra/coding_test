package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek17298 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int[] now = new int[]{Integer.parseInt(st.nextToken()),i};
            while(!stack.isEmpty() && stack.peek()[0]<now[0]){
                int[] temp = stack.pop();
                arr[temp[1]] = now[0];
            }
            stack.add(now);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        System.out.println(sb.toString());

    }
}
