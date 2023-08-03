package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int len = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        char[] arr = reader.readLine().replaceAll(" ", "").toCharArray();
        Arrays.sort(arr);
        recur(new boolean[arr.length + 1], arr, new char[len], 0);
        System.out.println(sb.toString().trim());
    }

    public static char[] vowl = { 'a', 'e', 'i', 'o', 'u' };
    public static StringBuilder sb = new StringBuilder();

    public static void recur(boolean[] visited, char[] arr, char[] result, int idx) {
        if (idx == result.length) {
            String temp = new String(result);
            int vowlCount = vowlCount(temp);
            if (vowlCount > 0 && temp.length() - vowlCount > 1) {
                sb.append(temp);
                sb.append(System.lineSeparator());
            }

            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (!visited[i]) {
                result[idx] = arr[i];
                if (idx > 0) {
                    if (result[idx - 1] >= result[idx]) {
                        continue;
                    }
                }
                visited[i] = true;
                recur(visited, arr, result, idx + 1);
                visited[i] = false;
            }
        }
    }

    public static int vowlCount(String s) {
        int result = 0;
        for (char c : vowl) {
            if (s.indexOf(c) > 0) {
                result += 1;
            }
        }
        return result;
    }
}
