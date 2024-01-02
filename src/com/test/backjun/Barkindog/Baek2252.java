package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

// 위상정렬
public class Baek2252 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] count = new int[n+1];
        List<Integer>[] list = new ArrayList[n+1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[b].add(a);
            count[a]+=1;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < count.length; i++) {
            if(count[i]==0){
                q.offer(i);
            }
        }

        int[] result = new int[n];
        int idx =0;
        while(!q.isEmpty()){
            int now = q.poll();
            result[idx++] = now;
            for (int i : list[now]) {
                count[i]-=1;
                if(count[i]==0){
                    q.add(i);
                }
            }
        }
        int len = result.length;
        StringBuilder sb = new StringBuilder();
        while(len-->0){
            sb.append(result[len]).append(" ");
        }
        System.out.println(sb.toString());
        // System.out.println(Arrays.toString(result));
    }
}
