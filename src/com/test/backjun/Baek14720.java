package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14720 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader =  new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] milks = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int now = 0;
        int count =0;
        for (int i = 0; i < milks.length; i++) {
            milks[i] = Integer.parseInt(st.nextToken());
            if(milks[i]%3==now){
                count+=1;
                now+=1;
                now %=3;
            }
        }
        System.out.println(count);
        
    }
}
