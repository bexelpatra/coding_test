package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1068 {
    static List<Integer>[]  tree;
    static int target;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        tree = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }
        int root =0;
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < tree.length; i++) {
            int now = Integer.parseInt(st.nextToken());
            if(now == -1){
                root = i;
            }else{
                tree[i].add(now);
                tree[now].add(i);
            }
        }
        
        target = Integer.parseInt(reader.readLine());
        visited[target] = true;
        if(target == root){
            System.out.println(0);
            return;
        }
        visited[root] = true;
        dfs(root);
        
        System.out.println(count);
    }
    static boolean[] visited;
    static int count=0;
    public static void dfs(int idx){
        boolean isLeaf = true;
        for (int node : tree[idx]) {
            
            if(!visited[node]){
                visited[node]=true;
                isLeaf=false;
                dfs(node);
            }
        }
        if(isLeaf){
            count+=1;
        }
    }
}
