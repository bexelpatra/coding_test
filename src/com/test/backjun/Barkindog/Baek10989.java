package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek10989 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] sort = new int[10001];
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(reader.readLine());
            sort[now]+=1;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sort.length; i++) {
            while(sort[i]-->0){
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
