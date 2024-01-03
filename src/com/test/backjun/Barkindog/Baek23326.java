package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Baek23326 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        TreeMap<Integer,Integer> map  = new TreeMap<>();
        int now = 1;
        st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < n+1; i++) {
            if(st.nextToken().equals("1")){
                map.put(i, 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            String order = st.nextToken();
            if("1".equals(order)){
                int num = Integer.parseInt(st.nextToken());
                Integer att = map.get(num);
                if(att==null){
                    map.put(num, 1);
                }else{
                    map.remove(num);
                }
            }else if("2".equals(order)){
                int num = Integer.parseInt(st.nextToken());
                now += num%n;
                now %= n;
                if( now == 0){
                    now = n;
                }
            }else{
                Integer next = map.ceilingKey(now);
                if(next == null){
                    // 없거나 앞에 있다.
                    if(map.isEmpty()){
                        sb.append(-1);
                    }else{
                        sb.append(n - (now-map.firstKey()));
                    }
                }else{
                    sb.append(next-now);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
