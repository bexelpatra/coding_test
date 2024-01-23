package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 기존 메소드에 의존이 과한 코드다.
public class Baek2870 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> {
            int a = o1.length();
            int b = o2.length();
            if(a==b){
                return o1.compareTo(o2);
            }
            return a-b;
        });
        for (int i = 0; i < n; i++) {
            String[] now = reader.readLine().split("[a-z]+");
            for (int j = 0; j < now.length; j++) {
                if(now[j].length() ==0)continue;
             int idx = 0;

             while(now[j].charAt(idx)=='0'){
                idx +=1;
                if(idx == now[j].length()){
                    break;
                }
             }
             if(idx == now[j].length()){
                now[j] = "0";
             }else{
                 now[j] = now[j].substring(idx, now[j].length());
             }
             
             pq.add(now[j]);
            }
            
            
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
        System.out.println(sb.toString());
    }
}
