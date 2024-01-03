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
        int n = Integer.parseInt(reader.readLine());
        TreeSet<int[]> set = new TreeSet<>((o1, o2) ->{
            if(o1[1]==o2[1]){
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1];
        });
        Map<Integer,int[]> map = new HashMap<>();
        StringTokenizer st ;
        for (int i = 0; i < n; i++) {
            st= new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] p = new int[]{a,b};
            set.add(p);
            map.put(a, p);
        }
        int m = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String order = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if("add".equals(order)){
                int lev = Integer.parseInt(st.nextToken());
                int[] add = new int[]{num,lev};
                set.add(add);
                map.put(num, add);
            }else if("solved".equals(order)){
                int[] solved = map.remove(num);
                set.remove(solved);
            }else{
                if(num == 1){
                    sb.append(set.last()[0]);
                }else{
                    sb.append(set.first()[0]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

        // fail();
    }

    private static void fail() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer,TreeSet<Integer>> map = new TreeMap<>(); // level 이  key
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
            numLevMap.put(num, lev);
        }
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@" + map.lastKey());
        int m = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String order = st.nextToken();
            if(order.equals("add")){
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                map.computeIfAbsent(a, o->{
                return new TreeSet<>();
                });
                map.get(a).add(b);
                numLevMap.put(b, a);
            }else if(order.equals("solved")){
                int a = Integer.parseInt(st.nextToken());
                map.get(numLevMap.get(a)).remove(a);
                numLevMap.remove(a);
            }else{
                int a = Integer.parseInt(st.nextToken());
                Integer temp = 0;
                if(a==1){
                    temp = map.get(map.lastKey()).last();
                    sb.append(temp);
                }else{
                    temp = map.get(map.firstKey()).first();
                    sb.append(temp);
                }
                System.out.println(temp);
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
