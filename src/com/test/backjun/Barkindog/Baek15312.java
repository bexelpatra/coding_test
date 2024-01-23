package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Baek15312 {
    static int[] count = {3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a= reader.readLine();
        String b= reader.readLine();
        int[] arr = new int[a.length() *2];
        int idx =0;
        for (int i = 0; i < a.length(); i++) {
            arr[idx++] = count[a.charAt(i)-'A'];
            arr[idx++] = count[b.charAt(i)-'A'];
        }
        sum(arr);
        System.out.printf("%02d",answer);
    }
    static int answer = 0;
    public static void sum(int[] arr){
        // System.out.println(Arrays.toString(arr));
        if(arr.length==2){
            for (int i = 0; i < arr.length; i++) {
                answer*=10;
                answer+=arr[i];
            }
            return;
        }
        int idx = 0;
        int[] next= new int[arr.length-1];
        for (int i = 1; i < arr.length; i++) {
            next[idx] = arr[i-1] + arr[i];
            next[idx] %=10;
            idx+=1;
        }
        sum(next);
    }
}
