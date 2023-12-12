package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2193 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[] zero = new long[n+1];
        long[] one = new long[n+1];
        zero[1]=0;
        one[1]=1;
        
        for (int i = 2; i < one.length; i++) {
            zero[i] = zero[i-1] + one[i-1];
            one[i] = zero[i-1];
        }
        // System.out.println(Arrays.toString(zero));
        // System.out.println(Arrays.toString(one));
        System.out.println(zero[n]+one[n]);

    }
}
