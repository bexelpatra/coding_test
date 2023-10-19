package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class Baek7785 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        getSb2();
    }
    private static void getSb2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String,Boolean> map = new TreeMap<>((o1, o2) -> compare(o2, o1));
        for (int i = 0; i < n; i++) {
            String[] temp = reader.readLine().split(" ");
            if("enter".equals(temp[1])){
                map.put(temp[0], true);
            }else{
                map.put(temp[0], false);
            }
        }
        // treemap은 못쓰겠다...
        StringBuilder sb = new StringBuilder();
        map.keySet().forEach(t -> System.out.println(map.get(t)));
        map.forEach((t, u) -> {
            // System.out.println(t + " "+ u);
            if(u){
                sb.append(t).append("\n");
            }
        });
        System.out.println(sb.toString());
    }
    private static void getSb() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Map<String,Boolean> map = new HashMap<>();
        // Map<String,Boolean> map = new TreeMap<>((o1, o2) -> compare(o2, o1));
        for (int i = 0; i < n; i++) {
            String[] temp = reader.readLine().split(" ");
            if("enter".equals(temp[1])){
                map.put(temp[0], true);
            }else{
                map.put(temp[0], false);
            }
        }
        // map.forEach((t, u) -> System.out.println(t));
        PriorityQueue<String> pq = new PriorityQueue<>((o1, o2) -> compare(o2, o1));
        for (String key : map.keySet()) {
            if(map.get(key)){
                pq.add(key);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            sb.append(pq.poll()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int compare(String a, String b){
        // 길이 짧음?
        // 같으면 ? 
        int temp = 0;
        if(a.length() >= b.length()){
            for (int i = 0; i < b.length(); i++) {
                temp = a.charAt(i)-b.charAt(i);
                if(temp==0){
                    continue;
                }else {
                    return temp;
                }
            }
            return 1;
        }else{
            for (int i = 0; i < a.length(); i++) {
                temp = a.charAt(i)-b.charAt(i);
                if(temp==0){
                    continue;
                }else {
                    return temp;
                }
            }
            return -1;
        }
    }
}
