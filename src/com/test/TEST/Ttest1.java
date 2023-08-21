package com.test.TEST;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ttest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(reader.readLine());
        // long target = Long.parseLong(st.nextToken());
        // int k = Integer.parseInt(st.nextToken());
        long target = 7;
        int k = 6;
        long result = Long.MAX_VALUE;
        if(target<=k){
            System.out.println(0);
            return;
        }
        while(k-- >0){
            int n = getSq(target);
            int next = n+1;
            long a = target - pow(n);
            long b= pow(next) - target;
            result = Math.min(b, result);
            System.out.println(String.format("%d : %d %d %d",n, a,b,result));
            target= a;

        }
        System.out.println(result);
    }

    public static int getSq(long target){
        int idx = 1;
        while(target -pow(idx) > 0){
            idx+=1;
        }
        return idx-1;
    }
    public static long pow(int time){
        long result= 1;
        for (int i = 0; i < time; i++) {
            result*=2;
        }
        return result;
    }
}
