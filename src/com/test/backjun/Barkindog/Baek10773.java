package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10773 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int idx =0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            if(now == 0){
                idx = idx -1>=0 ? idx-1:-1;
            }else{
                if(idx <0){
                    idx =0;
                }
                arr[idx++] = now;
            }
        }
        int sum =0;
        for (int i = 0; i < idx; i++) {
            sum+= arr[i];
        }
        System.out.println(sum);
    }
}
