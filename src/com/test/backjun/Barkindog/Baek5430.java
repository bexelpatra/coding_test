package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

import com.test.backjun.BaekImpl;

public class Baek5430 implements BaekImpl<String> {
    static int start = 0;
    static int end = 0;
    public static StringBuilder sb;

    @Override
    public String getResult(BufferedReader reader) throws Exception {
        // TODO Auto-generated method stub
        int n = Integer.parseInt(reader.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String func = reader.readLine();
            int l = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine(), "[],");

            Deque<Integer> dq = new LinkedList<>();
            for (int j = 0; j < l; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean pass = true;
            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        // 에러
                        sb.append("errer").append("\n");
                        pass = false;
                        break;
                    } else {
                        if (reverse) { // 역방
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }
            if (pass) {
                print(dq, reverse);
            }
            // if (pass) {
            // sb.append("[");
            // if (reverse) {
            // while (!list.isEmpty()) {
            // sb.append(list.pollLast()).append(",");
            // }
            // } else {
            // while (!list.isEmpty()) {
            // sb.append(list.pollFirst()).append(",");
            // }
            // }
            // if (sb.charAt(sb.length() - 1) == ',') {
            // sb.deleteCharAt(sb.length() - 1);
            // }
            // sb.append("]\n");
            // }

        }
        return (sb.toString());
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String func = reader.readLine();
            int l = Integer.parseInt(reader.readLine());
            StringTokenizer st = new StringTokenizer(reader.readLine(), "[],");

            Deque<Integer> dq = new LinkedList<>();
            for (int j = 0; j < l; j++) {
                dq.add(Integer.parseInt(st.nextToken()));
            }

            boolean reverse = false;
            boolean pass = true;
            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    reverse = !reverse;
                } else {
                    if (dq.isEmpty()) {
                        // 에러
                        sb.append("errer").append("\n");
                        pass = false;
                        break;
                    } else {
                        if (reverse) { // 역방
                            dq.pollLast();
                        } else {
                            dq.pollFirst();
                        }
                    }
                }
            }
            if (pass) {
                print(dq, reverse);
            }
            // if (pass) {
            // sb.append("[");
            // if (reverse) {
            // while (!list.isEmpty()) {
            // sb.append(list.pollLast()).append(",");
            // }
            // } else {
            // while (!list.isEmpty()) {
            // sb.append(list.pollFirst()).append(",");
            // }
            // }
            // if (sb.charAt(sb.length() - 1) == ',') {
            // sb.deleteCharAt(sb.length() - 1);
            // }
            // sb.append("]\n");
            // }

        }
        System.out.println(sb.toString());
        // getN(reader);
    }

    public static void print(Deque<Integer> dq, boolean reverse) {
        sb.append('[');
        if (dq.size() > 0) {
            if (reverse) { // 역방
                sb.append(dq.pollLast());
                while (!dq.isEmpty()) {
                    sb.append(',').append(dq.pollLast());
                }
            } else {
                sb.append(dq.pollFirst());
                while (!dq.isEmpty()) {
                    sb.append(',').append(dq.pollFirst());
                }
            }
        }
        sb.append(']').append('\n');
    }

    private static void getN(BufferedReader reader) throws IOException {
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            String func = reader.readLine();
            int n = Integer.parseInt(reader.readLine());
            String temp = reader.readLine().replaceAll(",", "");
            char[] arr = Arrays.copyOfRange(temp.toCharArray(), 1, temp.length() - 1);

            start = 0;
            end = arr.length;

            boolean flag = true;
            for (char c : func.toCharArray()) {
                if (c == 'R') {
                    R();
                } else {
                    if (!D()) {
                        sb.append("error").append("\n");
                        flag = false;
                        break;
                    }
                }
            }
            // System.out.printf("start %d end %d \n",start,end);
            if (flag) {
                sb.append("[");
                if (start < end) {
                    for (int j = start; j < end; j++) {
                        sb.append(arr[j]).append(",");
                    }
                } else {
                    for (int j = start - 1; j >= end; j--) {
                        sb.append(arr[j]).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1);

                sb.append("]\n");
            }

        }
        System.out.println(sb.toString());
    }

    // 뒤집기
    public static void R() {
        // 정방향
        swap();
    }

    // 지우기
    public static boolean D() {

        if (start < end) { // 정방향
            start += 1;
            if (start == end) {
                return false;
            }
            return true;
        } else { // 역방향
            start -= 1;
            if (start < 0 || end < 0) {
                return false;
            }
            return true;
        }
    }

    public static void swap() {
        int temp = start;
        start = end;
        end = temp;
    }
}
