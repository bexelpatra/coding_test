package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1919 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        int[] arr = new int['z'-'a'+1];
        for (int i = 0; i < a.length(); i++) {
            arr[a.charAt(i)-'a'] +=1;
        }
        for (int i = 0; i < b.length(); i++) {
            arr[b.charAt(i)-'a'] -=1;
        }
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            count+= Math.abs(arr[i]);
        }
        System.out.println(count);
    }
}
