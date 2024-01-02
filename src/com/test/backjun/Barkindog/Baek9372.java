package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.Function;

public class Baek9372 {
    static Function<String,Integer> func = Integer::parseInt;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = func.apply(reader.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        while(loop-->0){
            st = new StringTokenizer(reader.readLine());
            int n = func.apply(st.nextToken());
            int m = func.apply(st.nextToken());
            for (int i = 0; i < m; i++) {
                reader.readLine();
            }
            sb.append(n-1).append("\n");
        }
        System.out.println(sb.toString());
    }
}
