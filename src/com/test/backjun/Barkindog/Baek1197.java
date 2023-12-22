package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    크루스칼 알고리즘
    union 할 때 a,b의 순서가 상관을 써야될것 같은데 안 써도 되기는 된다...
*/ 

public class Baek1197 {
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.add(new int[]{a,b,c});
        }
        list.sort((o1, o2) -> o1[2]-o2[2]);
        int answer = 0;
        for (int i = 0; i < e; i++) {
            int[] now = list.get(i);
            if(find(now[0])!= find(now[1])){
                union(now[0], now[1]);
                answer += now[2];
            }
        }
        System.out.println(answer);
    }
    static void union(int a , int b){
        a = find(a);
        b= find(b);
        if(a !=b ){
            parent[b] = a;
        }
    }
    static int find(int a){
        if(parent[a] ==a){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
