package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1003 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb= new StringBuilder();
        int[] zero = new int[41];
        int[] one = new int[41];
        zero[0] = 1;
        one[0] = 0;
        
        zero[1] = 0;
        one[1] = 1;
        
              
        for (int i = 2; i < 41; i++) {
            zero[i] = zero[i-1] + zero[i-2];
            one[i] = one[i-1] + one[i-2];
        }
        // System.out.println(Arrays.toString(zero));
        // System.out.println(Arrays.toString(one));
        StringTokenizer st = null;
        while(loop-->0){
            int now = Integer.parseInt(reader.readLine());
            
            sb.append(zero[now]).append(" ").append(one[now]).append("\n");
        }
        System.out.println(sb.toString());
    }
}
