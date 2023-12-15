package com.test.TEST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class TTest15 {
    public static void main(String[] args) {
        int n = 4;
        int[][] map = new int[n+1][n+1];
        int[][] dp = new int[n +1][n+1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                map[i][j] = i +j;
            }
        }
        Print(map);

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i][j-1] + map[i][j];
            }
        }
        
        // for (int i = 1; i < dp.length; i++) {
        //     for (int j = 1; j < dp[i].length; j++) {
        //         dp[i][j] =  dp[i-1][j]+dp[i][j-1] -dp[i-1][j-1] + map[i][j];
        //     }
        // }
        Print(dp);
        
        Map<String,Integer> hm = new LinkedHashMap<>();
        hm.put("1", 1);
        hm.put("2", 1);
        if(hm.get("1")!=null){
            hm.remove("1");
            hm.put("1", 2);
        }
        hm.forEach((t, u) -> System.out.println(t + ":"+u));
        
    }
    public static void Print(int[][] map ){
        StringBuilder sb=  new StringBuilder();

        for (int i = 0; i < map.length; i++) {
            sb.append(Arrays.toString(map[i])).append("\n");
        }
        System.out.println(sb.toString());
    }
}
