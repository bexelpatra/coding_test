package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2910 {
    static class Number implements Comparable<Number>{
        public int n;
        public int count;
        public int order;
        Number(int n, int count,int order){
            this.n = n;
            this.count = count;
            this.order = order;
        }

        @Override
        public int compareTo(Number o) {
            // TODO Auto-generated method stub
            if(this.count == o.count){
                return this.order - o.order;
            }
            return   o.count - this.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 개수
        int c = Integer.parseInt(st.nextToken()); // 숫자의 개수
        
        st = new StringTokenizer(reader.readLine());
        Number[] arr = new Number[c+1];
        for (int i = 0; i < n; i++) {
            int now =Integer.parseInt(st.nextToken());
            if(arr[now]==null){
                arr[now] = new Number(now, 0, i);
            }
            arr[now].count+=1;
        }
        StringBuilder sb=  new StringBuilder();
        Arrays.stream(arr)
        .filter(t -> {return t!=null;})
        .sorted()
        .forEach(t -> {
            while(t.count -->0){
                sb.append(t.n).append(" ");
            }
        });
        System.out.println(sb.toString());
    }
}
