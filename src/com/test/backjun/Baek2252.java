package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<Integer>[][] list = new List[n+1][2];
        for (int i = 0; i < list.length; i++) {
            list[i][0] = new ArrayList<>(); // 나보다 큰애
            list[i][1] = new ArrayList<>(); // 나보다 작은애
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int tall = Integer.parseInt(st.nextToken());
            int small = Integer.parseInt(st.nextToken());
            
            list[tall][1].add(small);
            list[small][0].add(tall);
        }

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < list.length; i++) {
            sb.append(i).append("보다 큰애");
            list[i][0].forEach(t -> sb.append(t).append(" "));
            sb.append("\n");
            
            sb2.append(i).append("보다 작은 애");
            list[i][1].forEach(t -> sb2.append(t).append(" "));
            sb2.append("\n");
        }

        System.out.println(sb.toString());
        System.out.println(sb2.toString());
    }
}
