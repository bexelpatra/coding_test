package com.test.TEST;

import java.util.Arrays;
import java.util.stream.IntStream;

// backtracking
public class TTest12 {
    static int[] arr;
    public static void main(String[] args) {
        int n = 4;
        arr = IntStream.range(1, n+1).toArray();
        int m =7;

        System.out.println((char)('a' -32));
        // dfs(new boolean[n], new int[n], 0);
    }
    public static void dfs(boolean[] visited,int[] temp, int idx){
        if(idx == visited.length){
            System.out.println(Arrays.toString(temp));
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                temp[idx] =arr[i];
                dfs(visited,temp,idx+1);
                visited[i] = false;
            
            }
        }
        
    }
}
