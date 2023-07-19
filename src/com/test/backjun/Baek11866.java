package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Baek11866 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = next(reader);
        int k = next(reader);
        getMySol(n, k);
        getReference(n, k);
    }

    private static void getReference(int n, int k) {
        int temp = 0;
        List<Integer> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder("<");
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        while (!list.isEmpty()) {
            temp = (temp + k - 1) % n;
            sb.append(list.get(temp));
            if (n != 1) {
                sb.append(", ");
            }
            list.remove(temp);
            n -= 1;
        }
        sb.append(">");
        System.out.println(sb.toString());
    }

    // queue 를 이용해서 계속 돌리는 방식
    private static void getMySol(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.add(i + 1);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder("<");
        while (!q.isEmpty()) {
            int now = q.poll();
            if ((count += 1) % k == 0) {
                count = 0;
                sb.append(now);
                sb.append(", ");
                continue;
            }
            q.add(now);
        }
        sb.delete(sb.length() - 2, sb.length());
        sb.append(">");
        System.out.println(sb.toString());
    }

    public static int next(BufferedReader reader) throws Exception {
        int n = 0;
        int c = '`';
        while ((c = reader.read()) > -1) {
            if (c == 32 || c == 13 || c == 10) {
                break;
            }
            n *= 10;
            n += (char) (c - '0');
        }
        return n;
    }
}
