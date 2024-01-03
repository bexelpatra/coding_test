package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// trie 방식
public class Baek5052_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringBuffer sb = new StringBuffer();
        while(loop-->0){
            int n = Integer.parseInt(reader.readLine());
            Node node = new Node();
            for (int i = 0; i < n; i++) {                
                node.insert(reader.readLine());
            }
            if(flag){
                sb.append("YES");
            }else{
                sb.append("NO");
            }
            sb.append("\n");
            flag = true;
        }
        System.out.println(sb.toString());

    }
    static boolean flag = true;
    static class Node{
        Map<Character,Node> map = new HashMap<>();
        boolean end;
        boolean haveMore;

        void insert(String str){
            Node now = this;
            int len = str.length();
            for (int i = 0; i < len; i++) {
                if(now.map.get(str.charAt(i)) == null) {
                    now.map.put(str.charAt(i), new Node());
                }
                now = now.map.get(str.charAt(i));
                if(i < len-1){
                    now.haveMore = true;
                }
                if(now.haveMore && now.end){
                    flag = false;
                }
            }
            now.end = true;
            if(now.haveMore && now.end){
                flag=false;
            }
        }
    }
}
