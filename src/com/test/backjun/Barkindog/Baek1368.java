package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 이건 틀림...
public class Baek1368 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] price = new int[n+1];
        
        for (int i = 0; i < n; i++) {
            price[i+1] = Integer.parseInt(reader.readLine());
        }
        StringTokenizer st;
        PriorityQueue<Node> pq= new PriorityQueue<>();
        List<Node>[] list = new List[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 1; i < n+1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                int val = Integer.parseInt(st.nextToken());
                if(i==j){
                    val= 100_000+1;
                }
                Node node = new Node(i,j,val);
                list[i].add(node);
            }
        }
        int answer = Integer.MAX_VALUE;
        int sum =0;
        for (int i = 1; i < price.length; i++) {
            boolean[] visited = new boolean[n+1];
            int num = n; 
            sum+= price[i];
            visited[i] = true;
            for (Node temp : list[i]) {
                pq.add(temp);
            }
    
            while(!pq.isEmpty()){
                Node now = pq.poll();
                if(visited[now.to]){
                    continue;
                }
                num-=1;
                visited[now.to] = true;
                sum+= Math.min(price[now.from],now.val);
                
                for (Node temp : list[now.to]) {
                    if(!visited[temp.to]){
                        pq.add(temp);
                    }
                }
    
                if(num==1){
                    break;
                }
            }
            answer = Math.min(sum , answer);
            // System.out.println(sum);
            sum=0;

        }
    
        System.out.println(answer);
    }
    static class Node implements Comparable<Node>{
        int from;
        int to;
        int val;
        Node(int from, int to, int val){
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
