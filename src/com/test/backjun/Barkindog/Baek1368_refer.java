package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.function.Function;

// prim 알고리즘
//https://bacchus-lover.tistory.com/115
public class Baek1368_refer {
    private static final int INF = 987654321;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        Function<String,Integer> stoi = Integer::parseInt;
        int n = stoi.apply(st.nextToken());
        int[] price = new int[n];
        int[][] map = new int[n][n];
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            price[i] = stoi.apply(st.nextToken());
        }
        for(int i = 0 ; i < n ; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j = 0 ; j < n ; j++){
                map[i][j] = stoi.apply(st.nextToken());
            }
        }
        int result = INF;
        for(int idx = 0 ; idx < n ; idx++){
            int[] distance = new int[n];
            boolean[] visited = new boolean[n];
            Arrays.fill(distance,INF);
            int temp = price[idx];
            distance[idx] = 0;
            for(int i = 0 ; i < n ; i++){
                int minIndex = 0;
                int minValue = INF;
                for(int j = 0 ; j < n ; j++){ // 안 간곳 중에서 최솟값 찾기
                    if(!visited[j] && distance[j] < minValue){
                        minValue = distance[j];
                        minIndex = j;
                    }
                }
                visited[minIndex] = true;
                temp += minValue;
                for(int j = 0 ; j < n ; j++){
                    int nextValue = Math.min(map[minIndex][j],price[j]);
                    if(!visited[j] && j != minIndex && distance[j] > nextValue){
                        distance[j] = nextValue;
                    }
                }
            }
            // System.out.println(temp);
            result = Math.min(result, temp);
        }
        System.out.println(result);
    }
}

