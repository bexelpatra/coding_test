package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Baek21939_2 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>();
        Map<Integer,Integer> numLevMap = new HashMap<>();
        StringTokenizer st;
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int num = Integer.parseInt(st.nextToken());
            int lev = Integer.parseInt(st.nextToken());
            map.computeIfAbsent(lev, o->{
                return new TreeSet<>();
            });
            map.get(lev).add(num);
        }

        int m = Integer.parseInt(reader.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                int a = Integer.parseInt(st.nextToken());
            }else if(order.equals("solved")){

            }else{
                
            }
        }
        
    }
}
