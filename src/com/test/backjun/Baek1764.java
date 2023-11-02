package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Boolean> heard = new HashMap<>();

        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            heard.put(reader.readLine(), true);
        }
        String now = "";
        for (int i = 0; i < m; i++) {
            now = reader.readLine();
            if (heard.getOrDefault(now, false)) {
                result.add(now);
            }
        }
        Collections.sort(result);
        StringBuilder sb = new StringBuilder();

        sb.append(result.size());
        sb.append("\n");
        result.forEach(t -> sb.append(t).append("\n"));
        System.out.println(sb.toString());
    }

}
