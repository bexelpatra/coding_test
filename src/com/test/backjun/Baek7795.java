package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek7795 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        while(n-->0){
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] pred = new int[a];
            int[] prey = new int[b];
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < pred.length; j++) {
                pred[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < prey.length; j++) {
                prey[j] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(pred);
            Arrays.sort(prey);

            int lo = 0;
            int hi = prey.length-1;
            int mid = 0;

            int count = 0;

            // lowwer
            for (int i = 0; i < pred.length; i++) {                
                while(lo<hi){
                    mid = (lo+hi)/2;
                    if(pred[i] <= prey[mid]){
                        hi = mid;
                    }else{
                        lo = mid+1;
                    }
                }
                
                if(pred[i]>prey[lo]){
                    lo+=1;
                }
                count+=lo;
                lo=0;
                hi=prey.length-1;
            }
            sb.append(count).append("\n");
        }
        System.out.println(sb.toString());
    }
}
