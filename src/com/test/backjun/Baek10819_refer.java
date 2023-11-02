package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

//https://www.acmicpc.net/source/12786797
public class Baek10819_refer {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> numbers = new ArrayList<>();
        ArrayList<Integer> results = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            numbers.add(Integer.parseInt(st.nextToken()));
        }
        // Sort
        Collections.sort(numbers);
        int small = 0;
        int big = numbers.size() - 1;
        // flag
        boolean turn = true;
        while (small <= big) {
            if (small == big) {
                int first = Math.abs(results.get(0) - numbers.get(small));
                int end = Math.abs(results.get(results.size() - 1) - numbers.get(small));
                if (first < end) {
                    results.add(numbers.get(small));
                } else {
                    results.add(0, numbers.get(small));
                }
            } else if (turn) {
                turn = false;
                results.add(0, numbers.get(small));
                results.add(numbers.get(big));
            } else {
                turn = true;
                results.add(numbers.get(small));
                results.add(0, numbers.get(big));
            }
            small++;
            big--;
        }
        int result = 0;
        for (int i = 0; i < results.size() - 1; i++) {
            result = result + Math.abs(results.get(i) - results.get(i + 1));
        }
        System.out.println(result);
    }
}
