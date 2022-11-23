package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1005 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        for (int i = 0; i < loop; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int n =  Integer.parseInt(st.nextToken());
            int k =  Integer.parseInt(st.nextToken());
            int[] price = new int[n+1];
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j < n+1; j++) {
                price[j] = Integer.parseInt(st.nextToken());
            }
            List<Integer>[] list = new List[n+1];
            Map<Integer,List<Integer>> map = new HashMap<>();
            for (int j = 0; j < n+1; j++) {
                list[j] = new ArrayList<>();
            }
            int minIndex =Integer.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(reader.readLine());
                int a= Integer.parseInt(st.nextToken());
                int b= Integer.parseInt(st.nextToken());

                list[a].add(b);
                map.getOrDefault(a,new ArrayList<>()).add(b);
            }
            Arrays.sort(list,(o1, o2) -> {
                return o1.size() - o2.size();
            });

            int target = Integer.parseInt(reader.readLine());
            int[] dp = new int[n+1];
//            dp[1] = price[1];
            for (int j = 1; j < n+1; j++) {
                for (int l = 0; l < list[j].size(); l++) {
                    int x = list[j].get(l);
                    dp[x] = Math.max(dp[j]+price[x],dp[x]);
                }
            }

//
//            System.out.println();
//            for (int j = 0; j < n+1; j++) {
//                System.out.printf("%d ",dp[j]);
//            }
//            System.out.println();
//            for (int j = 0; j < n+1; j++) {
//                System.out.printf("%d ",price[j]);
//            }
//            System.out.println();
            System.out.println(dp[target]);
        }
    }
}
