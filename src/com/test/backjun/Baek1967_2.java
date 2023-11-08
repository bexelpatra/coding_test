package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1967_2 {
    public static List<int[]>[] tree ;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        tree = new List[n+1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        int last = 0;
        StringTokenizer st ;
        for (int i = 0; i < n-1; i++) {

            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());

            tree[from].add(new int[]{to,val});
            tree[to].add(new int[]{from,val});
            last = from;
        }
        
        for (int i = 1+last; i < n+1; i++) {
           checked= new boolean[n+1];
        //     // dfs(new boolean[n+1],i,0,0);
            checked[i] = true;
            dfs(i,0);
        }

        System.out.println(max);
    }
    static boolean[] checked;
    static int max = 0;
    static int maxIdx = 0;
    public static void dfs(int idx,int val){
      if(max<val){
        max = val;
        maxIdx = idx;
      }
      for (int[] node : tree[idx]) {
        if(!checked[node[0]]){
            checked[node[0]]  = true;
            dfs(node[0],val+node[1]);
        }
      }
    }
    // public static void dfs(boolean[] visited,int idx,int val,int lastVal){
    //     if(visited[idx]){
    //         max =Math.max(max, val-lastVal);
    //        return; 
    //     }
    //     visited[idx] = true;
    //     tree[idx].forEach(t ->{
    //         dfs(visited, t[0], val+t[1],t[1]);
    //     } );
    // }
}
