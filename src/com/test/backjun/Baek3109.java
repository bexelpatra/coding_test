package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek3109 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        sol1(reader);
    }

    //https://wiselog.tistory.com/140
    private static void sol1(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] graph = new char[R][C];
        for (int i = 0; i < R; i++) {
            graph[i] = reader.readLine().toCharArray();
        }
        int ans =0;
        for (int i = 0; i < R; i++) {
            if(recursive(graph,C,R,i,0)){
                ans++;
            }
        }
        System.out.println(ans);
    }

    public static boolean recursive(char[][] graph, int C, int R,int nowX,int nowY){
        graph[nowX][nowY] = '-'; // 사용함 표시
        if (C-1==nowY){
            return true;
        }
        if (nowX>0 && graph[nowX-1][nowY+1]=='.'){
            if(recursive(graph,C,R,nowX-1,nowY+1)){
                return true;
            }
        }
        if (graph[nowX][nowY+1]=='.'){
            if(recursive(graph,C,R,nowX,nowY+1)){
                return true;
            }
        }
        if (nowX+1<R && graph[nowX+1][nowY+1]=='.'){
            if(recursive(graph,C,R,nowX+1,nowY+1)){
                return true;
            }
        }
        return false;
    }
}
