package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10942 {
    static int[] arr;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 1; i < n+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }  
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb= new StringBuilder();
        for (int i = 0; i < loop; i++) {
            st = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            sb.append(isPel(start, end)?1:0).append("\n");
        }
        System.out.println(sb.toString());

    }
    public static boolean isPel(int start, int end){
        boolean result = true;
        while(start < end){
            if(arr[start] !=arr[end]){
                result = false;
                break;
            }
            start +=1;
            end -=1;
        }
        return result;
    }
}
