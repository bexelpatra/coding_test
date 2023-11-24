package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1931 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] meetings = new int[n][2];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            meetings[i][0] = Integer.parseInt(st.nextToken());
            meetings[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(meetings,(a,b)->{
            if(a[1]==b[1]){
                return a[0] - b[0];
            }
            return a[1]-b[1];
        });
        int[] now = meetings[0];
        int cnt= 1;
        for (int i = 1; i < meetings.length; i++) {
            if(now[1]<=meetings[i][0]){
                now = meetings[i];
                cnt+=1;
            }
        }

        System.out.println(cnt);
        
    }
}
