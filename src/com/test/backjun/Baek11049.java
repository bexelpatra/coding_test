package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek11049 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][2];
        dp = new int[n];
        StringTokenizer st = null;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0] =map[0][0]* map[0][1];
        if(n>1){
            dp[1] = map[0][0]*map[1][0] * map[1][1];
        }
        if(n>2){
            reduce(map, new int[][]{map[0],map[1],map[2]}, 2);
        }
        System.out.println(Arrays.toString(dp));
        System.out.println(dp[n-1]);
    }
    static int[] dp = null;
    public static int[][] compare(int[] a, int[] b,int[] c,int idx){
        int f = a[0]*(b[0]*b[1] + c[0]*c[1]);
        int r = c[1]*(b[0]*b[1]+a[0]*a[1]);
        if(f>r){
            a[1] = b[1];
            b = c;
            c= null;
            dp[idx] = r;
        }else{
            b[1] = c[1];
            c= null;
            dp[idx] = f;
        }
        return new int[][]{a,b,c};

    }

    public static void reduce(int[][] arr,int[][] compareArr,int idx){
        if(idx == arr.length){
            return ;
        }
        int[][] result =compare(arr[0], arr[1], arr[2],idx);
        result[2] = arr[idx];
        idx+=1;
        reduce(arr,result,idx);
    }
}
