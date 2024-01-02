package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek21940 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int INF = 987654321;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][n+1];

        for (int[] is : map) {
            Arrays.fill(is, INF);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[a][b] = c;
        }

        int f = Integer.parseInt(reader.readLine());
        int[] arr = new int[f];
        st = new StringTokenizer(reader.readLine());

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int stop = 1; stop < n+1; stop++) {
            for (int from = 1; from < n+1; from++) {
                for (int to = 1; to < n+1; to++) {
                    map[from][to] = Math.min(map[from][to], map[from][stop] + map[stop][to]);
                    // if(map[from][stop]!=0 && map[stop][to] !=0){

                    //     int sum = map[from][stop] + map[stop][to];

                    //     if(map[from][to]==0){
                    //         map[from][to] = sum;
                    //     }else{
                    //         map[from][to] = Math.min(map[from][to], sum);
                    //     }
                    // }
                }
            }
        }

        int max =INF;
        int[] answer = new int[n];
        int idx = 0;
        for (int i = 1; i < n+1; i++) {
            int now =0 ;
            for (int friend : arr) {
                if(i==friend){
                    continue;
                }
                now = Math.max(map[friend][i]+map[i][friend], now);
                // if(map[friend][i] !=0 && map[i][friend] !=0 ){
                //     num = Math.max(num, map[friend][i] + map[i][friend]) ;
                // }else{
                //     num = INF *2;
                // }
            }
            if(max > now){
                max = now;
                idx =0 ;
                answer[idx++] = i;
            }else if (max == now){
                answer[idx++] = i;
            }
        }
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < idx; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.println(sb.toString());
    }
}
