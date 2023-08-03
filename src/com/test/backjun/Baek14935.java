package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek14935 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        String last = "";
        String now = "";
        int i = 10;
        while (i-- > 0) {
            target = FA(target);
            System.out.println(target);
        }
    }

    public static String FA(String src) {
        int a = (int) (src.charAt(0) - '0');
        return String.valueOf(a * src.length());
    }
}
