package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baek1647 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int val = Integer.parseInt(st.nextToken());
            Node temp = new Node(from, to, val);
            list.add(temp);
        }
        Collections.sort(list);
        long sum = 0;
        int max = -1;
        int i =0;
        for ( i = 0; i < list.size(); i++) {
            Node now = list.get(i);
            if(n == 1){
                break;
            }
            if(union(now.from, now.to)){
                max = Math.max(max, now.val);
                sum += now.val;
                n--;
            }
        }
        System.out.println(sum - max);
    }
    static int[] parent;
    static int find(int a){
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static boolean union(int a, int b){
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
    static class Node implements Comparable<Node>{
        int from,to,val;
        Node(int from,int to, int val){
            this.from = from;
            this.to = to;
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.val - o.val;
        }
    }
}
