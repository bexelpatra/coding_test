package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek10026 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        char[][] graph = new char[n][n];
        for (int i = 0; i <n; i++) {
            graph[i] = reader.readLine().toCharArray();
        }
        boolean[][] visited = new boolean[n][n];
        int a =0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    BFS(graph,visited,i,j,n,graph[i][j]);
                    a+=1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j]=='G'){
                    graph[i][j]='R';
                }
            }
        }

        int b =0;
        visited = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!visited[i][j]){
                    BFS(graph,visited,i,j,n,graph[i][j]);
                    b+=1;
                }
            }
        }

        System.out.printf("%d %d",a,b);
    }
    public static void BFS(char[][] graph,boolean[][] visited,int x, int y, int n, char before){
        if (x ==n || y==n || x<0 || y <0){
            return;
        }
        if (visited[x][y]){
            return;
        }
        if (before == graph[x][y]){
            visited[x][y] = true;
            BFS(graph,visited,x+1,y,n,graph[x][y]);
            BFS(graph,visited,x,y+1,n,graph[x][y]);
            BFS(graph,visited,x,y-1,n,graph[x][y]);
            BFS(graph,visited,x-1,y,n,graph[x][y]);
        }
    }
}
