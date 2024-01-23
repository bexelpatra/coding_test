package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baek1213 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        char[] n = reader.readLine().toCharArray();
        int[] arr = new int['Z'-'A'+1];
        for (int i = 0; i < n.length; i++) {
            arr[n[i]-'A']+=1;
        }
        boolean even = n.length % 2 ==0;
        List<Character> list = new ArrayList<>();

        int mid = -1;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==0) continue;
            if(arr[i] %2==0){
                for (int j = 0; j < arr[i]/2; j++) {
                    list.add((char)(i+'A'));
                }
            }else{
                if(even){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }else{
                    if(mid ==-1){
                        mid = i;
                    for (int j = 0; j < arr[i]/2; j++) {
                        list.add((char)(i+'A'));
                    }
                    }else{
                        System.out.println("I'm Sorry Hansoo");
                        return;

                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }
        if(!even){
            sb.append((char)(mid+'A'));
        }
        int idx = list.size();
        while(idx-->0){
            sb.append(list.get(idx));
        }
        System.out.println(sb.toString());
        
    }
}
