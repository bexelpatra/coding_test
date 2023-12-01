package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Baek2910_2 {
   
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken()); // 총 개수
        int c = Integer.parseInt(st.nextToken()); // 숫자의 개수
        
        st = new StringTokenizer(reader.readLine());
        HashMap<Integer,Integer> map = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            int now =Integer.parseInt(st.nextToken());
            
            int mapNow = map.getOrDefault(now, 0);
            map.put(now, mapNow+1);
        }
        List<Integer> list = new ArrayList<>(map.keySet());
        list.sort((o1, o2) ->{
            return map.get(o2) - map.get(o1);
        } );
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int now = map.get(num);
            while(now -->0){
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb.toString());
        
    }
}
