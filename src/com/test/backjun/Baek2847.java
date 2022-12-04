package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek2847 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] order = new int[n];
        for (int i = 0; i < n; i++) {
            order[i] = Integer.parseInt(reader.readLine());
        }
        long ans = 0;
        for (int i = n-1; i > 0; i--) {
            if (order[i] <= order[i-1]){
                ans += order[i-1] - order[i] +1;
                order[i-1] = order[i]-1;
            }
        }
        System.out.println(ans);
    }
}
