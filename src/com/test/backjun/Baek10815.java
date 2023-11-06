package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek10815 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int m = Integer.parseInt(reader.readLine());
        st = new StringTokenizer(reader.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <m; i++) {
            int now = Integer.parseInt(st.nextToken());
            int hi = hi(arr, now);
            int lo = lo(arr, now);
            sb.append(hi - lo).append(" ");
        }
        System.out.println(sb.toString());

    }

    public static int lo(int[] arr, int idx){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = (hi+lo) / 2;
            if(idx <= arr[mid]){
                hi =mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }
    public static int hi(int[] arr, int idx){
        int lo = 0;
        int hi = arr.length;
        while(lo < hi){
            int mid = (hi+lo) / 2;
            if(idx<arr[mid]){
                hi =mid;
            }else{
                lo = mid+1;
            }
        }
        return lo;
    }

}
