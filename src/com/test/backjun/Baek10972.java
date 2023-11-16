package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

// 스왑을 통해서 구할 수 있다....
// fail
// 모든 경우의  수를 둘러보기에는 시간초과
public class Baek10972 {
    static int[] arr;
    static int[] target;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        target = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        arr = IntStream.range(1, n+1).toArray();

        // dfs(new boolean[n], new int[n], 0);
        boolean[] visited = new boolean[n];
        // Arrays.fill(visited, true);
        // visited[n-1] =false;
        dfs(visited, new int[n], 0);
        if(sb.length()==0){
            sb.append(-1);
        }
        System.out.println(sb.toString());
        
    }
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(boolean[] visited,int[] result,int idx){
        if(visited.length  == idx){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx] = arr[i];
                dfs(visited,result,idx+1);
                visited[i] = false;
            }
        }
    }
    public static boolean same(int[] a, int[] b){
        for (int i = 0; i < b.length; i++) {
            if(a[i] != b[i]){
                return false;
            }
        }
        return true;
    }
}
