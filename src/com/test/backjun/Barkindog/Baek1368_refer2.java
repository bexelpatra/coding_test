package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.function.Function;

// 크루스칼 알고리즘
//
public class Baek1368_refer2 {
    static int[] parent;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] price = new int[n+1];
        parent = new int[n+1];
        Function<String,Integer> atoi = Integer::parseInt;
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 1; i < n+1; i++) {
            price[i] = Integer.parseInt(reader.readLine());
            parent[i] = i;
        }

        StringTokenizer st;
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                int now = atoi.apply(st.nextToken());
                if(i==j){
                    pq.add(new Node(0, j, price[i]));
                }else{
                    pq.add(new Node(i, j, now));
                }
            }
        }
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        pq.stream().forEach(t -> sb.append(String.format("%d %d %d\n", t.from,t.to,t.val)));
        System.out.println(sb.toString());
        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(union(now.from, now.to)){
                answer+= now.val;
            }
        }
        System.out.println(answer);
    }
    static boolean union(int a, int b){
        a=find(a);
        b=find(b);
        if(a==b){
            return false;
        }
        if(a>b){
            parent[a] = b;
        }else{
            parent[b]=a;
        }
        return true;
    }
    static int find(int a){
        if(a== parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
    static class Node implements Comparable<Node>{
        int from,to,val;
        public Node(int from, int to, int val){
            this.from = from;
            this.to= to;
            this.val = val;
        }
        @Override
        public int compareTo(Node o) {
            // TODO Auto-generated method stub
            return this.val-o.val;
        }
    }
}

