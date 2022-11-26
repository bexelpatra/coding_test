package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1025 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        char[][] graph = new char[n][m];

        // graph 생성
        for (int i = 0; i < n; i++) {
            String temp = reader.readLine();
            graph[i] = temp.toCharArray();
        }

        for (int i = 0; i < n; i++) { // 세로(열)
            for (int j = 0; j < m; j++) { // 가로(행)

            }
        }

    }
    public static int search(char[][] graph,int x, int y,int n, int m){
        if(x>n-1 || y > m-1){
            return 0;
        }
        return 0;
    }

    public static int reverse(int n){
        int reverse=0;
        for(int i=10;n>0;){
            reverse*=10;
            reverse+= n%i;
            n/=i;
        }
        return reverse;
    }
}
