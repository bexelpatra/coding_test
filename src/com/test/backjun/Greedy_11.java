package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Greedy_11 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = 0;
        a = Integer.parseInt(br.readLine());
        int len = a/3;
        int[][] arr = new int[len][];
        arr[0] = new int[] {3,5};
        if(a == 3 || a==5) {
            System.out.println(1);
            for (int[] ar: arr) {
                System.out.println(Arrays.toString(ar));
            }
            return;
        }
        for(int i =1;i<len ;i++) {
            int[] t = new int[i+2];
            for(int j=0; j<i+1;j++) {
                t[j] = arr[i-1][j] + 3;
                if(j == i) {
                    t[j+1] = arr[i-1][j] +5;
                    if(t[j+1] == a) {
                        System.out.println(i+1);
                        for (int[] ar: arr) {
                            System.out.println(Arrays.toString(ar));
                        }
                        return;
                    }
                }
                if(t[j] == a) {
                    System.out.println(i+1);
                    for (int[] ar: arr) {
                        System.out.println(Arrays.toString(ar));
                    }
                    return;
                }
            }
            arr[i] = t;
        }
        System.out.println(-1);
    }
}
