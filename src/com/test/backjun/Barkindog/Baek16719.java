package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 무작정 세어가는 방법도 한가지 방법중의 하나
 * 문제의 조건을 살펴서 진행한다.
 */
public class Baek16719 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        arr=  reader.readLine().toCharArray();
        visited = new boolean[arr.length];
        dfs(0, arr.length-1);
        System.out.println(sb.toString());

        
    }
    static char[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static void dfs(int lo, int hi){
        if(lo<=hi){
            int maxIdx = lo;
            for (int i = lo; i < hi+1; i++) {
                if(arr[i]<arr[maxIdx]){
                    maxIdx = i;
                }
            }
            visited[maxIdx] = true;
            for (int i = 0; i < arr.length; i++) {
                if(visited[i]){
                    sb.append(arr[i]);
                }
            }
            sb.append("\n");
            dfs(maxIdx+1, hi);
            dfs(lo, maxIdx-1);
        }
    }
}
