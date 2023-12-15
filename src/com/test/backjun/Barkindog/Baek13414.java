package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek13414 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < m; i++) {
            String num = reader.readLine();
            map.put(num, i);
            if(map.get(num)!=null){
                map.remove(num);
                map.put(num, i);
            }
        }
        StringBuilder sb=  new StringBuilder();
        for (String key : map.keySet()) {
            sb.append(key).append("\n");
            n--;
            if(n==0){
                break;
            }
        }
        System.out.println(sb.toString());
        
    }
}
