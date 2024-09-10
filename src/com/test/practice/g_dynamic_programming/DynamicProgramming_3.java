package com.test.practice.g_dynamic_programming;

// import org.junit.Assert;
// import org.junit.Test;

import java.util.Arrays;

public class DynamicProgramming_3 {
    // 깊이우선 탐색 다시 실패...
    // 재귀적으로 하면 효율성이 매우 안좋은듯하다.
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] map = new int[m][n];
        int x = 0;
        int y = 0;
        dfs(map,x,y,puddles,0);
        System.out.println(count%(1000*100*100+7));
        return count % (1000*100*100+7);
    }
    int count =0;
    private void dfs(int[][] map, int x, int y,int[][] puddles,int move) {
        if(x<0|| x>map.length-1) return;
        if(y<0 || y>map[x].length-1) return;
        if(puddle(puddles,x,y)) return;
        if(move > map.length-1 + map[x].length-1) return;
        if(x == map.length-1&& y == map[x].length-1){
            count++;
            return;
        }
        move +=1;
        dfs(map,x+1,y,puddles,move);
        dfs(map,x,y+1,puddles,move);
    }
    private boolean puddle(int[][] puddle,int x,int y){
        return Arrays.stream(puddle).filter(ints -> ints[0]==x&&ints[1]==y).count() >0 ? true: false;
    }
    // https://velog.io/@ajufresh/%EB%93%B1%EA%B5%A3%EA%B8%B8
    public int solution2(int m, int n, int[][] puddles) {

        int[][] map = new int[n][m];
        for (int[] puddle : puddles) {
            map[puddle[1]-1][puddle[0]-1] = -1;
        }
        map[0][0] = 1;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
//                Arrays.stream(map).forEach(
//                        ints -> {
//                            Arrays.stream(ints).forEach(value -> System.out.print(value));
//                            System.out.println("");
//                        });
//                System.out.println();
                if(map[i][j] == -1){
                    map[i][j] = 0;
                    continue;
                }
                if(i!=0){
                    map[i][j] += map[i-1][j] % (10*10000*10000 +7);
                }
                if(j!=0){
                    map[i][j] += map[i][j-1] % (10*10000*10000 +7);
//                    1000000007
                }
            }
        }
        return map[n-1][m-1] % (1000*100*100 +7);
    }

    // 2021-8-22 다시 풀어본다.
    // 아이디어를 기억하고 있으니 수월하게 풀렸으면한다.
    public int solution3(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] path = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                path[i][j] = i+j;
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("i,j : %d,%d",i,j);
            }
            System.out.println();
        }
        return answer;
    }
  
}
