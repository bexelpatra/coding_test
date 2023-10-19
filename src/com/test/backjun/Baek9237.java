package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek9237 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // getMax();
        getMax2();
        
    }

    // 틀림
    // left에 대해서 제대로 계산을 해줘야 하는듯 하다.
    private static void getMax2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int day = 0;
        int idx =n;
        int left = 0;
        while(idx -->0){
            int now = trees[idx];
            day +=1;

            if(left <= now+day+1){
                left = now +1;
            }
        }
        System.out.println(day + left);
    }


    private static void getMax() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        
        int[] trees = new int[n];
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(trees);
        int day = 0;
        int idx =n;
        
        int max = 0;

        while(idx -->0){
            int now = trees[idx];
            day +=1;
            max = Math.max(max, now + day +1);
        }
        System.out.println(max);
    }

}
