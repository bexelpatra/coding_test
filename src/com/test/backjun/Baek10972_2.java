package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://pangtrue.tistory.com/327
// 규칙을 찾으면 충분히 풀수 있는 문제다.
public class Baek10972_2 {

    static int[] target;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());

        target = new int[n];
        for (int i = 0; i < n; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        int i =n;
        while(i -->1){
            if(target[i] > target[i-1]){
                break;
            }
        }
        if(i==0){
            System.out.println(-1);
            return;
        }
        int j = n ;
        while(j-->0){
            if(target[j] > target[i-1]){
                swap(j,i-1);
                break;
            }
        }
        Arrays.sort(target, i, n);
        StringBuilder sb = new StringBuilder();
        for (int x : target) {
            sb.append(x).append(" ");
        }
        // System.out.println(Arrays.toString(target));
        System.out.println(sb.toString());
        
    }

    public static void swap(int a, int b){
        int temp = target[a];
        target[a] = target[b];
        target[b] = temp;
    }
}
