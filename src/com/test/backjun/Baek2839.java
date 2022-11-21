package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] answer = new int[n/3+5];
        if (n==3|| n==5){
            System.out.println(1);
            return;
        }
        for (int i = 1; i < answer.length; i++) {
            for (int j = 0; j <i; j++) {
                answer[j]+=3;
                if (answer[j] == n){
                    System.out.println(i);
                    return;
                }
            }
            answer[i]=i*5;
            if(answer[i]==n){
                System.out.println(i);
                return;
            }
        }

        System.out.println(-1);
    }
}
