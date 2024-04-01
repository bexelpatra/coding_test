package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 시간 초과
public class Baek1325 {

    static List<Integer>[] list;
    static int[] count;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        list = new ArrayList[n+1];
        count = new int[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
        }

        for (int i = 1; i < list.length; i++) {
            re(i,i,new boolean[n+1]);
        }

        int max = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < count.length; i++) {
            if(max > count[i]){
                continue;
            }else if(max == count[i]){
                result.add(i);
            }else{
                max = count[i];
                result.clear();
                result.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        result.forEach(t -> sb.append(t).append(" "));
        System.out.println(sb.toString());
    }
    public static void re(int now,int next,boolean[] visited){
        count[now] += list[next].size();
        visited[next] = true;
        for (int i : list[next]) {
            if(!visited[i]){
                re(now, i,visited);
            }
        }
    }
}
