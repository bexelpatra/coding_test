package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2512 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] ds = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine()," ");

        int max =0;
        int total = 0;
        for (int i = 0; i < ds.length; i++) {
            ds[i] = Integer.parseInt(st.nextToken());
            if(max < ds[i]){
                max = ds[i];
            }
            total+= ds[i];
        }
        int bud = Integer.parseInt(reader.readLine());
        if(total <=bud){
            System.out.println(max);
            return;
        }

        int lo=0;
        int hi = max;
        int mid = 0;

        
        while(lo < hi){
            int temp = 0;
            mid = (hi+lo)/2;
            for (int i = 0; i < ds.length; i++) {
                int now = ds[i] ;
                if(now>mid){
                    now = mid;
                }
                temp += now;
            }
            if(bud < temp){
                hi = mid;
            }else{
                lo = mid+1;
            }
        }
        System.out.println(lo-1);
    }
}
