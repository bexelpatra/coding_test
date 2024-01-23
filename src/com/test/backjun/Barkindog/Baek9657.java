package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek9657 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(reader.readLine());
        boolean[] arr = new boolean[n+3];
        arr[1] = true;
        arr[3] = true;
        arr[4] = true;
        // 1 - 상근
        int[] next = new int[]{1,3,4};
        for (int i = 5; i < n+1; i++) {
            boolean flag = false;
            for (int nxt : next) {
                if(i - nxt>0 && !arr[i-nxt]){
                    flag = true;
                }
            }
            arr[i] = flag;
        }
        for (int i = 1; i < arr.length -2; i++) {
            System.out.printf("%d : %s\n",i , arr[i]);
        }
        System.out.println(arr[n] ? "SK":"CY");

    }
}
