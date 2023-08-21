package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//회문은 회문이 아니야
public class Baek15927 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sentence = reader.readLine();
        int c = sentence.charAt(0);
        boolean flag = true;

        for (int i = 0; i < sentence.length(); i++) {
            if (c - sentence.charAt(i) != 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            System.out.println(-1);
            return;
        }
        int result = sentence.length();
        if (isPal(sentence)) {
            result -= 1;
        }
        System.out.println(result);
    }

    public static boolean isPal(String line) {
        char[] arr = line.toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            if (arr[i] - arr[arr.length - 1 - i] != 0) {
                return false;
            }
        }
        return true;
    }
}
