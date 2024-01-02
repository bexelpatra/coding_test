package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 합집합을 실행한 횟수를 차감하면서 계산
//https://www.acmicpc.net/source/41743591
public class Baek11724_refer {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int component = n;
        parent = new int[n+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    
        
        for (int i = 0; i < m; i++) {    
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a, b)){
                component-=1;
                if(component==1){
                    break;
                }
            }
        }
        System.out.println(component);
        
    }
    static int[] parent;


    static boolean union(int a, int b) {
        a= find(a);
        b = find(b);
        if (a == b){
            return false;
        }

        if (parent[a] < parent[b]) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }

        return true;
    }
    static int find(int a) {
        if(a == parent[a]){
            return a;
        }
        return parent[a] = find(parent[a]);
    }
}
