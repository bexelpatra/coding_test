package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Baek9375 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Map<String, Integer> map = new HashMap<>();
            int items = Integer.parseInt(reader.readLine());
            int total = 1;
            for (int j = 0; j < items; j++) {
                String key = reader.readLine().split(" ")[1];
                Integer now = map.get(key);
                if (now == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, now + 1);
                }
            }
            for (String key : map.keySet()) {
                // System.out.println(String.format("%s : %d", key, map.get(key)));
                total *= (map.get(key) + 1);
            }
            total -= 1;
            sb.append(total);
            sb.append(System.lineSeparator());
        }
        System.out.println(sb.toString());
    }
}
