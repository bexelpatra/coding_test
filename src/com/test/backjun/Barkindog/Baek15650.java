package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek15650 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr  = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i+1;
        }
        recur(new boolean[n], new int[m], 0);
        System.out.println(sb.toString());
    }
    static int[] arr;
    public static void recur(boolean[] visited,int[] result,int idx){
        if(idx == result.length){
            // System.out.println(Arrays.toString(result));
            print(result);
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if(!visited[i]){
                if(idx >0){
                    if(result[idx-1] > arr[i]){
                        continue;
                    }
                }
                visited[i] = true;
                result[idx ]= arr[i];
                recur(visited,result,idx+1);
                visited[i] = false;
            }
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]).append(" ");
        }
        sb.append("\n");
    }
}
