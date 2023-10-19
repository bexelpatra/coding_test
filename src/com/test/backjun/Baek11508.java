package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Baek11508 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(reader.readLine()));
        }
        int result = 0;
        int idx = 0;
        while(!pq.isEmpty()){
            int now = pq.poll();
            idx+=1;
            if(idx%3 == 0){
                continue;
            }
            result += now;
        }
        System.out.println(result);
    }
}
