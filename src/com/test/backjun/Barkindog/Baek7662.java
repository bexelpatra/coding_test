package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek7662 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb =new StringBuilder();
        while(loop--> 0){
            int n = Integer.parseInt(reader.readLine());
            StringTokenizer st = null;
            String order ="";
            int num = 0;
            map = new HashMap<>();
            PriorityQueue<Integer> front = new PriorityQueue<>();
            PriorityQueue<Integer> rear = new PriorityQueue<>(Comparator.reverseOrder());
            for (int i = 0; i < n; i++) {
                st= new StringTokenizer(reader.readLine());
                order = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                if("I".equals(order)){
                    front.add(num);
                    rear.add(num);
                    map.put(num, map.getOrDefault(num, 0)+1);
                }else{
                    if(map.size()==0){
                        continue;
                    }
                    if(num ==1){
                        remove(rear);
                    }else{
                        remove(front);
                    }
                  
                }
            }
            if(map.size()==0){
                sb.append("EMPTY").append("\n");
            }else{
                int number = remove(rear);
                sb.append(number).append(" ");
                if(map.size()>0){
                    number = remove(front);
                }
                sb.append(number).append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    static Map<Integer,Integer> map;
    public static int remove(PriorityQueue<Integer> pq){
        int ans = 0;
        while(true){
            ans = pq.poll();
            int cnt = map.getOrDefault(ans, 0);
            if(cnt==0){
                continue;
            }
            if(cnt ==1){
                map.remove(ans);
            }else{
                map.put(ans, cnt-1);
            }
            break;
        }
        return ans;
    }
}
