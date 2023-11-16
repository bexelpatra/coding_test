package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1120 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String a = st.nextToken();
        String b = st.nextToken();
        int result = 0;
        if (a.length() > b.length()) {
            result = compare(a, b);
        } else {
            result = compare(b, a);
        }
        System.out.println(result);

    }

    public static int compare(String a, String b) {
        int diff = a.length() - b.length() + 1;
        int count = a.length() + 1;
        int temp = 0;
        for (int i = 0; i < diff; i++) {
            temp = 0;
            for (int j = 0; j < b.length(); j++) {
                if (b.charAt(j) != a.charAt(j + i)) {
                    temp += 1;
                }
            }
            count = Math.min(count, temp);
        }
        return count;
    }
}
