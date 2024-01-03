package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Baek1543 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ori = reader.readLine();
        String tar = reader.readLine();

        int count = 0;
        // count = getCount(ori, tar, count);
        ori.indexOf(tar);
        int idx =- tar.length();
        while(true){
            idx = ori.indexOf(tar,idx+tar.length());
            if(idx ==-1){
                break;
            }
            count+=1;
        }
        System.out.println(count);
    }

    /*
    * 실패
    * aababa
    * aba
    */    
    private static int getCount(String ori, String tar, int count) {
        int len = ori.length();
        while(true){
            ori = ori.replaceFirst(tar, "");
            if(len == ori.length()){
                break;
            }
            len = ori.length();
            count+=1;
        }
        return count;
    }
}
