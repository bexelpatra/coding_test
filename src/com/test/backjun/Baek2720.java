package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2720 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb= new StringBuilder();
        int[] coins = new int[]{25,10,5,1};
        for (int i = 0; i < n; i++) {
            int target = Integer.parseInt(reader.readLine());
            for (int j = 0; j < 4; j++) {
                sb.append(target/coins[j]);
                sb.append(" ");
                target%=coins[j];
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
