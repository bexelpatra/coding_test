package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek16398 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i]= i;
        }
        List<Node> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(i==j)continue;
                if(i<j){
                    Node temp = new Node(i, j, val);
                    list.add(temp);
                }
            }
        }
        Collections.sort(list);

        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            Node now = list.get(i);
            if(union(now.from, now.to)){
                sum+=now.val;
            }
        }

        System.out.println(sum);

    }
    static class Node implements Comparable<Node>{
        int from,to,val;
        Node(int from,int to,int val){
            this.from = from;
            this.to = to;
            this.val =val;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.val-o.val;
        }
    }
    static int[] parent;
    static boolean union(int a,int b){
        a = find(a);
        b = find(b);
        if(a==b){
            return false;
        }
        if(a>b){
            parent[a] = b;
        }else{
            parent[b] = a;
        }
        return true;
    }
    static int find(int a){
        if(a== parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    
}
