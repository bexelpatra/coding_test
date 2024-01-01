package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Baek7432 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        TreeMap<String,TreeMap> root = new TreeMap<>((o1, o2) -> o1.compareTo(o2));
        for (int i = 0; i < n; i++) {
            // String[] arr = reader.readLine().split("\\");
            List<String> arr = new ArrayList<>();
            String temp = reader.readLine();
            StringBuilder split=  new StringBuilder();
            for (char c : temp.toCharArray()) {
                if(c=='\\'){
                    arr.add(split.toString());
                    split = new StringBuilder();
                }else{
                    split.append(c);
                }
            }
            arr.add(split.toString());
            TreeMap<String,TreeMap> now = root;

            for (String key : arr) {
                TreeMap<String,TreeMap> next = now.getOrDefault(key, newMap());
                now.put(key, next);
                now = next;
            }
        }
        dfs(root, 0);
        // System.out.println();
        System.out.println(sb.toString());
    }
    static StringBuilder sb = new StringBuilder();
    public static void dfs(TreeMap<String,TreeMap> map,int dep){
        for (String key : map.keySet()) {
            sb.append(space(dep)).append(key).append("\n");
            dfs(map.get(key), dep+1);
        }
    }
    public static String space(int dep){
        StringBuilder temp  =new StringBuilder();
        for (int i = 0; i < dep; i++) {
            temp.append(" ");
        }
        return temp.toString();
    }
    public static TreeMap<String,TreeMap> newMap(){
        return new TreeMap<>((o1, o2) -> o1.compareTo(o2));
    }
}
