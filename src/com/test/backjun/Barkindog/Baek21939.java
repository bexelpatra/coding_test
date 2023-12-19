package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek21939 {
    static Map<Integer,Integer> map = new HashMap<>();
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        PriorityQueue<int[]> h = new PriorityQueue<>((o1, o2) -> { // 오름차순
            if(o2[1]==o1[1]){ // 난이도가 같다면?
                return o2[0]-o1[0];
            }
            return o2[1] - o1[1];
        });
        PriorityQueue<int[]> t = new PriorityQueue<>((o1, o2) -> { // 내림차순
            if(o2[1]==o1[1]){ // 난이도가 같다면?
                return o1[0]-o2[0];
            }
            return o1[1] - o2[1];
        });
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int[] now = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
            h.add(now);
            t.add(now);
            map.put(now[0], now[1]);
        }

        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(reader.readLine());
            String type = st.nextToken();
            int l = Integer.parseInt(st.nextToken());

            if("add".equals(type)){
                int l2 = Integer.parseInt(st.nextToken());
                int[] temp = new int[]{l,l2};
                h.add(temp);
                t.add(temp);
                map.put(l, l2);

            }else if("solved".equals(type)){
                map.put(l,0);
            }else{
                if(l==1){
                    sb.append(clear(h)[0]);
                }else{
                    sb.append(clear(t)[0]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());

    }
    public static int[] clear(PriorityQueue<int[]> pq){
        int[] now ;
        while(true){
            now = pq.peek();
            int count = map.getOrDefault(now[0],0);
            if(count==0){
                map.put(now[0],0);
                pq.poll();
                continue;
            }
            if(now[1]!=count){
                map.put(now[0], count);
                pq.poll();
                continue;
            }
            break;
        }
        return now;
    }
}
