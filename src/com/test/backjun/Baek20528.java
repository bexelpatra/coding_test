package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek20528 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String line = reader.readLine();
        char standard = line.charAt(0);
        String[] words = line.split(" ");
        for (int i = 0; i < words.length; i++) {
            if (words[i].charAt(0) - standard != 0) {
                System.out.println(0);
                return;
            }
        }
        System.out.println(1);
    }
}
