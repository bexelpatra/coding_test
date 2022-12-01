package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek11721 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        char[] str = reader.readLine().toCharArray();
        for (int i = 0; i < str.length; i++) {
            sb.append(str[i]);
            if(i%10==9){
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
