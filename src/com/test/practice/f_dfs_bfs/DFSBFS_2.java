package com.test.practice.f_dfs_bfs;

// import org.junit.Assert;
// import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFSBFS_2 {
    // 방식 1번 : 실패
    // 전체를 그래프같은 느낌으로 탐색해서 그런듯 하다.
    int count = 0;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        int[][] check = new int[n][n];

        for(int i=0; i<computers.length;i++){
            for(int j=0; j< computers[0].length;j++){
                recursive(computers,check,j,i,n);
            }

        }
        System.out.println(count);
        return answer;
    }

    private void recursive(int[][] computers,int[][] check,int x, int y,int n){
        
        if(x < 0) return;
        if(y < 0) return;
        if(x>n-1||y>n-1) return;
        if(check[x][y] ==0){
            check[x][y] = 1;
            if(computers[x][y]==0) return;
            recursive(computers,check,x+1,y,n);
            recursive(computers,check,x,y+1,n);
            recursive(computers,check,x-1,y,n);
            recursive(computers,check,x,y-1,n);
            count ++;
            System.out.println("counted!!!");
        }
    }

    public int solution2(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];

        for(int i=0; i < n; i++){
            if(check[i] != 1){
                dfs(check, i, computers);
                answer++;
            }

        }
        return answer;
    }

    private void dfs(int[] check,int i, int[][] computers){
        check[i] = 1;
        for(int j =0;j < computers[i].length;j++){
            if(i!= j && computers[i][j] !=0 && check[j] ==0){
                dfs(check,j,computers);
            }
        }
    }

    //
    public int solution3(int n, int[][] computers) {
        int answer = 0;
        int[] check = new int[n];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(0);
        while(!deque.isEmpty()){
            int now = deque.pollFirst();
            for(int i=0; i < computers[now].length;i++){

            }
        }
        return answer;
    }
    
}
