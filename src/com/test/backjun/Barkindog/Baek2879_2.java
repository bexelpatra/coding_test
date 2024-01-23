package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek2879_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int a = o1.length();
            int b = o2.length();
            if(a==b){
                return o1.compareTo(o2);
            }
            return a-b;
        });

        while(n-->0){
            String str = reader.readLine();
            for (int i = 0; i < str.length(); i++) {
                char now = str.charAt(i);
                if('0'<= now && now <='9'){
                    sb.append(now);
                }else{
                    if(!sb.toString().equals("")){

                        removeZero2(sb);
                        pq.add(sb.toString());
                        sb.setLength(0);
                    }
                }
            }
            if(!sb.toString().equals("")){

                removeZero2(sb);
                pq.add(sb.toString());
                sb.setLength(0);
            }

        }
        StringBuilder result = new StringBuilder();
        while(!pq.isEmpty()) result.append(pq.poll()).append("\n");
        System.out.println(result.toString());
    }
    static void removeZero2(StringBuilder sb){
        int idx = 0;
        while(sb.charAt(idx)==0){
            idx+=1;
            if(idx == sb.length()){
                sb.setLength(0);
                sb.append('0');
                return;
            }
        }
        sb.delete(0, idx);
    }
}
