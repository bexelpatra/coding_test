package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;


/*
이분탐색으로 생각했다.
1. 이분탐색시 탐색 방향을 잡을 조건을 찾기위해서 고민했지만 적절한 방법을 찾지 못했다.
2. 탐색 시작 전에 위 아래로 훑어보는 것도 시도해볼법 해 보인다.
 */
public class Baek2470 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        List<Integer> po = new ArrayList<>();
        List<Integer> ne = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            arr[i] = temp;
            if (temp > 0) {
                po.add(temp);
            } else {
                ne.add(temp);
            }
        }
        Arrays.sort(arr);

        Collections.sort(po);
        Collections.sort(ne);

        StringBuilder sb = new StringBuilder();
        if (ne.size() == 0) {
            sb.append(po.get(0)).append(" ").append(po.get(1));
            System.out.println(sb.toString());
            return;
        }
        if (po.size() == 0) {
            int len = ne.size();
            sb.append(ne.get(len - 2)).append(" ").append(ne.get(len - 1));
            System.out.println(sb.toString());
            return;
        }
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;
        if (po.size() > 1) {
            a = po.get(0);
            b = po.get(1);
            min = a + b;
        }
        if (ne.size() > 1) {
            int len = ne.size();
            int tempa = ne.get(len - 2);
            int tempb = ne.get(len - 1);
            int tempMin = (tempa + tempb) * -1;
            if (min > tempMin) {
                a = tempa;
                b = tempb;
                min = tempMin;
            }
        }

        for (int i = 0; i < ne.size(); i++) {
            int lo = 0;
            int hi = po.size() - 1;
            int mid = 0;
            while (lo < hi) {
                mid = (lo + hi) / 2;
                if (Math.abs(po.get(mid) + ne.get(i)) == 0) {
                    sb.append(ne.get(i)).append(" ").append(po.get(mid));
                    System.out.println(sb.toString());
                    return;
                }
                if (po.get(mid) <= Math.abs(po.get(mid) + ne.get(i))) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            if (min > Math.abs(ne.get(i) + po.get(lo))) {
                min = Math.abs(ne.get(i) + po.get(lo));
                a = ne.get(i);
                b = po.get(lo);
            }
            // System.out.printf("%d vs %d --> %d\n", ne.get(i), po.get(lo), ne.get(i) +
            // po.get(lo));

        }
        sb.append(a).append(" ").append(b);
        System.out.println(sb.toString());
    }

}
