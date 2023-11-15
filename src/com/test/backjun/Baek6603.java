package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek6603 {
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        while(true){
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            if(n ==0){
                System.out.println(sb.toString().trim());
                return;
            }
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            recursive(new int[6], 0);
            sb.append("\n");
        }
    }

    public static void recursive(int[] result,int idx){
        if(idx == result.length){
            for (int i : result) {
                sb.append(i).append(" ");
            }
            sb.append("\n");
            // System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if(idx>0){
                if(result[idx-1] >=arr[i]){
                    continue;
                }
            }
            result[idx] = arr[i];
            recursive(result, idx+1);
        }
        
    }
}
