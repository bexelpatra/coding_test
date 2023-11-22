package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Baek1874 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n+1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        Stack<Integer> stack = new Stack<>();
        int idx = 1;
        int[] ans = new int[n+1];
        Queue<Integer> q = new LinkedList<>();
        StringBuilder pm = new StringBuilder();
        for (int i = 0; i < n; i++) {

            int now = Integer.parseInt(reader.readLine());
            ans[i+1] = now;
            while(idx <=now){
                stack.add(arr[idx++]);
                pm.append("+").append("\n");
            }
            q.add(stack.pop());
            pm.append("-").append("\n");
        }

        // StringBuilder sb = new StringBuilder();
        for (int i = 1; i < n+1; i++) {
            if(ans[i]!=q.poll()){
                System.out.println("NO");
                return;
            }
            // sb.append(q.poll());
        }
        System.out.println(pm.toString());
        // System.out.println(sb.toString());
        
    }
}
