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
        allCaseTest();
    }

    private static void allCaseTest() throws Exception {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                for (int j2 = 1; j2 < 7; j2++) {
                    System.out.printf("%d %d %d : %d\n", i, j, j2, solTest(i, j, j2));
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

    private static int solTest(int a, int b, int c) throws IOException {
        int[] arr = new int[7];
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

}
