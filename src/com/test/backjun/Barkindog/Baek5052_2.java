package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/*
 * trie 라는 방식
 * 메모리는 많이 잡아먹지만 빠르다.
 */
public class Baek5052_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while(loop-->0){
            int n = Integer.parseInt(reader.readLine());

        }
        System.out.println(sb.toString());
    }
    static class node{
        boolean isEnd;
        Map<Integer,node> map = new HashMap<>();
        boolean  insert(String number,int idx){
            node now = this;
            if(idx ==number.length()){
                isEnd = true;
                return true;
            }
            int key = number.charAt(idx)-'0';
            if(map.get(key)==null){
                map.put(key, new node());
                insert(number, idx+1);
            }
            
            return false;
        }
    }
}
