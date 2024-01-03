package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        StringBuilder sb = new StringBuilder();
        boolean java = false;
        boolean cpp = false;
        boolean cap = false;
        char first = name.charAt(0);
        char last = name.charAt(name.length()-1);
        if(first >='A' && first<='Z'){
            System.out.println("Error!");
            return;
        }
        if(first =='_' || last =='_'){
            System.out.println("Error!");
            return;
        }
        for (int i = 0; i < name.length(); i++) {
            char now = name.charAt(i);
            if(now >='A' && now <= 'Z'){ // 현재 자바
                java = true;
                sb.append("_").append((char)(now+32));
            }else if(now =='_'){ // 현재 cpp
                cpp = true;
                if(cap){
                    System.out.println("Error!");
                    return;
                }
                cap = true;
            }else{
                if(cap){
                    sb.append((char)(now - 32));
                    cap = false;
                }else{
                    sb.append(now);
                }
            }
        }
        if(java && cpp){
            System.out.println("Error!");
            return;
        }
        System.out.println(sb.toString());
    }
}
