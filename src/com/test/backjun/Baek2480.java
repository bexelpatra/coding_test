package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2480 {
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        // for (int i = 0; i < 6 * 6 * 6; i++) {
        // System.out.println(sol());
        // }
        // System.out.println(sb.toString());
        // extracted();
        for (String string : getList()) {

            System.out.println(solTest(string));
        }
    }

    private static void extracted() {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                for (int j2 = 1; j2 < 7; j2++) {
                    System.out.printf("\"%d %d %d,\" + \n", i, j, j2);
                }
            }
        }
    }

    private static int sol() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

        int[] arr = new int[7];
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr[a] += 1;
        arr[b] += 1;
        arr[c] += 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 3) {
                return 10000 + (i * 1000);
            } else if (arr[i] == 2) {
                return 1000 + (i * 100);
            } else if (arr[i] == 1) {
                max = i;
            }
        }
        return max * 100;
    }

    private static int solTest(String t) throws IOException {
        StringTokenizer st = new StringTokenizer(t, " ");
        System.out.print(t + " ");
        int[] arr = new int[7];
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr[a] += 1;
        arr[b] += 1;
        arr[c] += 1;
        int max = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 3) {
                return 10000 + (i * 1000);
            } else if (arr[i] == 2) {
                return 1000 + (i * 100);
            } else {
                max = i;
            }
        }
        return max * 100;
    }

    private static String[] getList() {
        String a = "1 1 1," +
                "1 1 2," +
                "1 1 3," +
                "1 1 4," +
                "1 1 5," +
                "1 1 6," +
                "1 2 1," +
                "1 2 2," +
                "1 2 3," +
                "1 2 4," +
                "1 2 5," +
                "1 2 6," +
                "1 3 1," +
                "1 3 2," +
                "1 3 3," +
                "1 3 4," +
                "1 3 5," +
                "1 3 6," +
                "1 4 1," +
                "1 4 2," +
                "1 4 3," +
                "1 4 4," +
                "1 4 5," +
                "1 4 6," +
                "1 5 1," +
                "1 5 2," +
                "1 5 3," +
                "1 5 4," +
                "1 5 5," +
                "1 5 6," +
                "1 6 1," +
                "1 6 2," +
                "1 6 3," +
                "1 6 4," +
                "1 6 5," +
                "1 6 6," +
                "2 1 1," +
                "2 1 2," +
                "2 1 3," +
                "2 1 4," +
                "2 1 5," +
                "2 1 6," +
                "2 2 1," +
                "2 2 2," +
                "2 2 3," +
                "2 2 4," +
                "2 2 5," +
                "2 2 6," +
                "2 3 1," +
                "2 3 2," +
                "2 3 3," +
                "2 3 4," +
                "2 3 5," +
                "2 3 6," +
                "2 4 1," +
                "2 4 2," +
                "2 4 3," +
                "2 4 4," +
                "2 4 5," +
                "2 4 6," +
                "2 5 1," +
                "2 5 2," +
                "2 5 3," +
                "2 5 4," +
                "2 5 5," +
                "2 5 6," +
                "2 6 1," +
                "2 6 2," +
                "2 6 3," +
                "2 6 4," +
                "2 6 5," +
                "2 6 6," +
                "3 1 1," +
                "3 1 2," +
                "3 1 3," +
                "3 1 4," +
                "3 1 5," +
                "3 1 6," +
                "3 2 1," +
                "3 2 2," +
                "3 2 3," +
                "3 2 4," +
                "3 2 5," +
                "3 2 6," +
                "3 3 1," +
                "3 3 2," +
                "3 3 3," +
                "3 3 4," +
                "3 3 5," +
                "3 3 6," +
                "3 4 1," +
                "3 4 2," +
                "3 4 3," +
                "3 4 4," +
                "3 4 5," +
                "3 4 6," +
                "3 5 1," +
                "3 5 2," +
                "3 5 3," +
                "3 5 4," +
                "3 5 5," +
                "3 5 6," +
                "3 6 1," +
                "3 6 2," +
                "3 6 3," +
                "3 6 4," +
                "3 6 5," +
                "3 6 6," +
                "4 1 1," +
                "4 1 2," +
                "4 1 3," +
                "4 1 4," +
                "4 1 5," +
                "4 1 6," +
                "4 2 1," +
                "4 2 2," +
                "4 2 3," +
                "4 2 4," +
                "4 2 5," +
                "4 2 6," +
                "4 3 1," +
                "4 3 2," +
                "4 3 3," +
                "4 3 4," +
                "4 3 5," +
                "4 3 6," +
                "4 4 1," +
                "4 4 2," +
                "4 4 3," +
                "4 4 4," +
                "4 4 5," +
                "4 4 6," +
                "4 5 1," +
                "4 5 2," +
                "4 5 3," +
                "4 5 4," +
                "4 5 5," +
                "4 5 6," +
                "4 6 1," +
                "4 6 2," +
                "4 6 3," +
                "4 6 4," +
                "4 6 5," +
                "4 6 6," +
                "5 1 1," +
                "5 1 2," +
                "5 1 3," +
                "5 1 4," +
                "5 1 5," +
                "5 1 6," +
                "5 2 1," +
                "5 2 2," +
                "5 2 3," +
                "5 2 4," +
                "5 2 5," +
                "5 2 6," +
                "5 3 1," +
                "5 3 2," +
                "5 3 3," +
                "5 3 4," +
                "5 3 5," +
                "5 3 6," +
                "5 4 1," +
                "5 4 2," +
                "5 4 3," +
                "5 4 4," +
                "5 4 5," +
                "5 4 6," +
                "5 5 1," +
                "5 5 2," +
                "5 5 3," +
                "5 5 4," +
                "5 5 5," +
                "5 5 6," +
                "5 6 1," +
                "5 6 2," +
                "5 6 3," +
                "5 6 4," +
                "5 6 5," +
                "5 6 6," +
                "6 1 1," +
                "6 1 2," +
                "6 1 3," +
                "6 1 4," +
                "6 1 5," +
                "6 1 6," +
                "6 2 1," +
                "6 2 2," +
                "6 2 3," +
                "6 2 4," +
                "6 2 5," +
                "6 2 6," +
                "6 3 1," +
                "6 3 2," +
                "6 3 3," +
                "6 3 4," +
                "6 3 5," +
                "6 3 6," +
                "6 4 1," +
                "6 4 2," +
                "6 4 3," +
                "6 4 4," +
                "6 4 5," +
                "6 4 6," +
                "6 5 1," +
                "6 5 2," +
                "6 5 3," +
                "6 5 4," +
                "6 5 5," +
                "6 5 6," +
                "6 6 1," +
                "6 6 2," +
                "6 6 3," +
                "6 6 4," +
                "6 6 5," +
                "6 6 6";

        String[] arr = a.split(",");
        System.out.println(arr.length);
        return arr;
    }
}
