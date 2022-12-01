package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek14916 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int five=0;
        if(n==3 || n==1){
            System.out.println(-1);
            return;
        }
        five += n/5;
        if(n%5 == 0){
            System.out.println(five);
        }else if(n%5==1){
            System.out.println(five-1+3);
        }else if(n%5==2){
            System.out.println(five+1);
        }else if(n%5==3){
            System.out.println(five-1+4);
        }else if(n%5==4){
            System.out.println(five+2);
        }
    }
}
