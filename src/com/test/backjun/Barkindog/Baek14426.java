package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baek14426 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeSet<String> tree = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            tree.add(reader.readLine());
        }
        StringBuilder sb = new StringBuilder();
        tree.forEach(t -> sb.append(t).append("\n"));
        long count = 0;
        for (int i = 0; i < m; i++) {
            String now = reader.readLine();
            String t = tree.ceiling(now);
            if(t == null){
                continue;
            }
            if(t.startsWith(now)){
                count+=1;
            }
        }
        System.out.println(count);
        System.out.println(sb.toString());
    }
}
