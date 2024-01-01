package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] arr = new String[n+1];
        Map<String,Integer> map = new HashMap<>();
        String name = "";
        for (int i = 0; i < n; i++) {
            name = reader.readLine();
            arr[i+1] = name;
            map.put(name, i+1);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            String key = reader.readLine();
            if(key.charAt(0) <='9' && key.charAt(0)>'0'){
                sb.append(arr[Integer.parseInt(key)]);
            }else{
                sb.append(map.get(key));
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        
    }
}
