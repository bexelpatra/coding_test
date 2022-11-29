package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 팰린드롬
public class Baek1213 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] name = reader.readLine().toCharArray();
        Arrays.sort(name);
        int nonono =0;
        int idx = -1;
        int nameLen = name.length;
        if (nameLen%2>0){
            idx = nameLen-1;
        }
        for (int i = 0; i < nameLen-1; i+=2) {
            if(name[i] != name[i+1]){
                nonono+=1;
                if (nonono>1 || nameLen %2==0){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                idx = i;
                i-=1;
            }
        }
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < (nameLen+1)/2; i+=1) {
            if(idx == i*2){
                continue;
            }
            list.add(name[i*2]);
        }
        char[] answer = new char[nameLen];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
            answer[nameLen-1-i] = list.get(i);
        }
        if(idx >-1){
            answer[nameLen/2] = name[idx];
        }

        System.out.println(String.valueOf(answer));


    }
//
//    public static void sol(BufferedReader reader) throws Exception{
//        char[] name =reader.readLine().toCharArray();
//        int[] abc = new int[26];
//        for (int i = 0; i < name.length; i++) {
//            abc[name[i]-'A'] +=1;
//        }
//        List<Character> c = new ArrayList<>();
//        char center = '0';
//        for (int i = 0; i < name.length; i++) {
//            if(abc[i]==0){
//                continue;
//            }
//            // 3 이거나 1일수도...
//        }
//
//    }
}
