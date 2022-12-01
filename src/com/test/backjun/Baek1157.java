package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1157 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] str = reader.readLine().toCharArray();
        char[] abc = new char[26];
        for (int i = 0; i < str.length; i++) {
            if(str[i] - 'a'>=0){
                abc[str[i]-'a']+=1;
            }else {
                abc[str[i]-'A']+=1;
            }
        }
        int max =-1;
        int priorMax = -1;
        int idx = -1;
        for (int i = 0; i < abc.length; i++) {
            if (abc[i]>max){
                max = abc[i];
                idx = i;
            }else if (abc[i]==max){
                priorMax = max;
            }
        }
        if (max - priorMax == 0){
            System.out.println("?");
        }else{
            System.out.println((char)(idx+'A'));
        }
    }
}
