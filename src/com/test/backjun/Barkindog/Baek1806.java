package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 마지막 숫자를 카운트하기 위해서 arr의 길이에 1을 더한다.
 */
public class Baek1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arr.length-1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int lo=0;
        int hi=1;
        int answer =100000+1;
        int sum=arr[0];
        while(hi<n+1){            
            if(sum <m){
                sum += arr[hi];
                hi+=1;
            }else{
                sum -= arr[lo];
                answer = Math.min(answer, hi-lo);
                lo+=1;
                if(lo==hi){
                    hi+=1;
                }
            }
        }
        System.out.println(answer == 100001 ? 0 : answer);
    }
}
