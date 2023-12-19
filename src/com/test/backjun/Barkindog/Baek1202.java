package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1202 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Jewel1202[] arr =  new Jewel1202[n];
        int[] bag = new int[m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            arr[i] = new Jewel1202(weight,value);
        }

        for (int i = 0; i < m; i++) {
            bag[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        Arrays.sort(bag);

        PriorityQueue<Jewel1202> pq = new PriorityQueue<>((o1, o2) -> {
            return o2.value - o1.value;
        });
        int idx = 0;
        long sum = 0;
        for (int i = 0; i < bag.length; i++) {
            int now = bag[i];
            while(idx < arr.length&&arr[idx].weight <= now){
                pq.add(arr[idx++]);
            }
            if(!pq.isEmpty()){
                sum+=pq.poll().value;
            }
        }

        System.out.println(sum);
    }
}

class Jewel1202 implements Comparable<Jewel1202>{
    public int weight;
    public int value;
    Jewel1202(int weight,int value){
        this.weight=weight;
        this.value = value;
    
    }
    @Override
    public int compareTo(Jewel1202 o) {
        if(this.weight==o.weight){
            return o.value- this.value;
        }
        return this.weight-o.weight;
    }
}