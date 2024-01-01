package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek2230 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr= new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        int start = 0;
        int end = 1;
        Arrays.sort(arr);

        long min = Integer.MAX_VALUE;
        while (start < n && end  < n) {
            long diff = arr[end] - arr[start];
            diff = diff>0?diff:diff *-1;
            if(diff < m){
                end +=1;
            }else{
                min = Math.min(min, diff);
                start +=1;
                if(start == end){
                    end+=1;
                }
            }
        }

        System.out.println(min);
    }
}
