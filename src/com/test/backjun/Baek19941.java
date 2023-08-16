package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek19941 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        String line = reader.readLine();
        boolean[] eat = new boolean[line.length()];
        int count = 0;
        int len = line.length();
        for (int i = 0; i < len; i++) {
            if (line.charAt(i) == 'P') {
                int temp = i - k;
                if (temp < 0) {
                    temp = 0;
                }

                while (temp <= i + k && temp < len) {
                    if (line.charAt(temp) == 'H' && !eat[temp]) {
                        eat[temp] = true;
                        count += 1;
                        break;
                    }
                    temp += 1;
                }

            }
        }
        // System.out.println(Arrays.toString(eat));
        System.out.println(count);
    }
}
