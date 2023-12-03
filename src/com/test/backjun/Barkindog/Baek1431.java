package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek1431 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        unit[] arr= new unit[n];
        for (int i = 0; i < n; i++) {
            String now = reader.readLine();
            arr[i] = new unit(now);
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i].s).append("\n");
        }
        System.out.println(sb.toString());

    }
    static class unit implements Comparable<unit>{
        public String s;
        public int n;
        unit(String s){
            this.s = s;
            for (char c : s.toCharArray()) {
                if(c <='9'){
                    n+= (c-'0');
                }
            }
        }
        
        @Override
        public int compareTo(unit o) {
            // TODO Auto-generated method stub
            if(this.s.length() == o.s.length()){
                if(this.n == o.n){
                    return this.s.compareTo(o.s);
                }
                return this.n - o.n;
            }
            return this.s.length() - o.s.length();
        }

    }
}
