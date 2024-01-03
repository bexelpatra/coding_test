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

public class Baek2623 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
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
            int len = Integer.parseInt(st.nextToken());
            int[] arr = new int[len];
            for (int j = 0; j < len ; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            for (int j = 0; j < len-1; j++) {
                list[arr[j+1]].add(arr[j]);
                count[arr[j]] +=1;
            }
            
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i < count.length; i++) {
            if(count[i]==0){
                q.offer(i);
            }
        }
        
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int now = q.poll();
            result.add(now);
            for(int k = 0; k < list[now].size();k++){
                int next  =list[now].get(k);
                count[next] -=1;
                if(count[next]==0){
                    q.offer(next);
                }
            }
        }
        if(result.size()!=n){
            System.out.println(0);
            return;
        }
        // for (int i = 1; i < count.length; i++) {
        //     if(count[i] !=0){
        //         System.out.println(0);
        //         return;
        //     }
        // }
        StringBuilder sb = new StringBuilder();
        int idx = result.size();
        while(idx -->0){
            sb.append(result.get(idx)).append("\n");
        }
        System.out.println(sb.toString());
    }
}
