package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek14426_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Node node= new Node();
        for (int i = 0; i < n; i++) {
            node.insert(reader.readLine());
        }
        int count =0;
        for (int i = 0; i < m; i++) {
            if(node.search(reader.readLine())){
                count+=1;
            }
        }
        System.out.println(count);
    }
    static int count = 0;
    static class Node{
        Map<Character,Node> map = new HashMap<>();
        boolean end;
        void insert(String str){
            Node now = this;
            for (int i = 0; i < str.length(); i++) {
                now = now.map.computeIfAbsent(str.charAt(i), c->new Node());
            }
            now.end = true;
        }

        boolean search(String str){
            Node now = this;
            for (int i = 0; i < str.length(); i++) {
                now = now.map.get(str.charAt(i));
                if(now == null){
                    return false;
                }
            }
            return true;
        }
    }
}
