package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15649 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        recur(new int[m], new boolean[n], 0);
        System.out.println(sb.toString());
    }
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void recur(int[] result,boolean[] visited, int idx){
        if(result.length == idx){
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx] = arr[i];
                recur(result,visited,idx+1);
                visited[i] = false;
            }
        }
    }
}
