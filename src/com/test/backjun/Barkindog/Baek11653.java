package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek11653 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int idx = 2;
        StringBuilder sb = new StringBuilder();
        while(idx <=n){
            if(n % idx ==0){
                sb.append(idx).append("\n");
                n= n/idx;
            }else{
                idx+=1;
            }
        }
        System.out.println(sb.toString());
    }
}
