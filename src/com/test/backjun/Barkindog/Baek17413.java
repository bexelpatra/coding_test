package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] str = reader.readLine().toCharArray();
        int idx = 0;
        while(idx < str.length){
            if(str[idx]=='<'){
                while(str[idx++]!='>'){}
            }else if(Character.isLetterOrDigit(str[idx])){
                int start = idx;
                while(idx < str.length && str[idx] != '<'&& str[idx] !=' '){
                    idx+=1;
                }
                int end = idx -1;
                reverse(str, start, end);
                if(idx < str.length && str[idx] != '<'){
                    idx +=1;
                }
            }
        }
        System.out.println(str);
        
    }
    // 외워두자.
    static void reverse(char[] arr,int start, int end){
        while(start< end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start +=1;
            end -=1;
        }
    }
    
}
