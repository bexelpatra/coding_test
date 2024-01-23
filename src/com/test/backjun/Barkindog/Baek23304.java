package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek23304 {
    static char[]n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = reader.readLine().toCharArray();
        check(0, n.length-1, n.length);
        if(flag){
            System.out.println("AKARAKA");
        }else{
            System.out.println("IPSELENTI");
        }
    }
    static boolean flag = true;
    static int c8=0;
    static void check(int start, int end,int len){
        if(len == 1 ){
            return;
        }
        int next = end - start + 1; // 길이
        int nextLen = next / 2;

        int mid = (end + start + 1) / 2;
        boolean even = (next)%2==0;
        
        int ns = start;
        int ne = end;
        while(ns < ne){
            if(n[ns++]!=n[ne--]){
                flag = false;
                return;
            }
        }
        if(even){
            check( start, mid-1, nextLen);
            check( mid, end, nextLen);
        }else{
            check( start, mid-1, nextLen);
            check( mid+1, end, nextLen);
        }
        
        
    }
}
