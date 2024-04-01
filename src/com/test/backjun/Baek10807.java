package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10807 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String target = reader.readLine();
        int count = 0 ;
        for (int i = 0; i < n; i++) {
            if(target.equals(st.nextElement())) count++;
        }
        System.out.println(count);
    }
}
