package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek1655 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        PriorityQueue<Integer> lo = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> hi = new PriorityQueue<>(Comparator.naturalOrder());
        
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            lo.add(now);
            // 좌우 크기 정렬
            while(hi.peek()!=null && lo.peek() > hi.peek()){
                hi.add(lo.poll());
            }
            // 중간에 맞게 정렬
            while(lo.size()<hi.size()){
                lo.add(hi.poll());
            }
            while(lo.size()>hi.size()+1){
                hi.add(lo.poll());
            }
            sb.append(lo.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}
