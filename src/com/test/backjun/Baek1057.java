package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Baek1057 implements BaekImpl<Integer> {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int p = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (p % 2 == 1) {
            p += 1;
        }

        int[] arr = IntStream.range(0, p + 1).toArray();
        int count = 1;
        // System.out.println(a + " : " + b);
        while (p > 0) {

            for (int i = 1; i < p + 1; i += 2) {
                // System.out.println(arr[i] + " vs " + arr[i + 1]);
                if (arr[i] == a && arr[i + 1] == b || arr[i] == b && arr[i + 1] == a) {
                    System.out.println(count);
                    return;
                }
                if (arr[i + 1] == a || arr[i + 1] == b) {
                    arr[i] = arr[i + 1];
                }

                arr[i / 2 + 1] = arr[i];
            }
            System.out.println(Arrays.toString(Arrays.copyOf(arr, p / 2)));
            p /= 2;
            count += 1;
        }
        System.out.println(-1);
    }

    @Override
    public Integer getResult(BufferedReader reader) throws Exception {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int p = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        if (p % 2 == 1) {
            p += 1;
        }

        int[] arr = IntStream.range(0, p + 1).toArray();
        int count = 1;
        // System.out.println(a + " : " + b);
        while (p > 0) {

            for (int i = 1; i < p + 1; i += 2) {
                // System.out.println(arr[i] + " vs " + arr[i + 1]);
                if (arr[i] == a && arr[i + 1] == b || arr[i] == b && arr[i + 1] == a) {
                    return count;
                }
                if (arr[i + 1] == a || arr[i + 1] == b) {
                    arr[i] = arr[i + 1];
                }

                arr[i / 2 + 1] = arr[i];
            }
            System.out.println(Arrays.toString(Arrays.copyOf(arr, p / 2)));
            p /= 2;
            count += 1;
        }
        return -1;
    }
}
