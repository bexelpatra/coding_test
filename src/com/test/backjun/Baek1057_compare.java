package com.test.backjun;

import java.io.BufferedReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Baek1057_compare implements BaekImpl<Integer> {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int zimin = sc.nextInt();
        int hansu = sc.nextInt();
        int count = 0;

        while (zimin != hansu) {
            zimin = zimin / 2 + zimin % 2;
            hansu = hansu / 2 + hansu % 2;
            count++;
        }
        System.out.println(count);

    }

    @Override
    public Integer getResult(BufferedReader reader) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int zimin = Integer.parseInt(st.nextToken());
        int hansu = Integer.parseInt(st.nextToken());
        int count = 0;

        while (zimin != hansu) {
            zimin = zimin / 2 + zimin % 2;
            hansu = hansu / 2 + hansu % 2;
            count++;
        }
        return count;
    }
}
