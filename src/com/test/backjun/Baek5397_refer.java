package com.test.backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//https://www.acmicpc.net/source/8890962
public class Baek5397_refer {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;

    static int T;

    static char[] left = new char[1000001], right = new char[1000001];
    public static void main(String args[]) throws Exception {

        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        while(T-- != 0) {

            String input = br.readLine();

            int leftCur = 0, rightCur = 0;

            int len = input.length();

            for(int i = 0; i < len; ++i) {

                if(input.charAt(i) == '<') {
                    if(leftCur == 0) continue;
                    right[rightCur++] = left[--leftCur];
                } else if(input.charAt(i) == '>') {
                    if(rightCur == 0) continue;
                    left[leftCur++] = right[--rightCur];
                } else if(input.charAt(i) == '-') {
                    if(leftCur == 0) continue;
                    leftCur--;
                } else {
                    left[leftCur++] = input.charAt(i);
                }
            }

            for(int i = 0; i < leftCur; ++i)
                bw.write(left[i]);
            for(int i = rightCur - 1; i >= 0; --i)
                bw.write(right[i]);
            bw.write("\n");
            bw.flush();
        }
    }
}
