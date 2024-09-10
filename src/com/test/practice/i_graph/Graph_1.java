package com.test.practice.i_graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class Graph_1 {
    // 가장 먼 노드
    public int solution(int n, int[][] edge) {
        int answer = 0;
        Set<Integer> setPrev = new HashSet<>();
        Set<Integer> setNext = new HashSet<>();
        for (int i = 0; i < edge.length; i++) {
            int[] e = edge[i];
            if(e[0]==1){
                setPrev.add(e[0]);
            }else if(e[1]==1){
                setPrev.add(e[1]);
            }

            if(e[0] > e[1]){
                int temp = e[0];
                e[0] = e[1];
                e[1] = temp;
                edge[i] = e;
            }
        }
        int cnt = 0;
        while (true){
            for (int[] e : edge) {
                if(setPrev.contains(e[0])){
                    setNext.add(e[1]);
                }
            }
            if(setNext.size() == 0) {
                answer = setPrev.size();
                break;
            }
            cnt++;
            setNext.removeAll(setPrev);
            setPrev.clear();
            setPrev.addAll(setNext);
            setNext.clear();
        }

        return answer;
    }
    public int solution2(int n, int[][] edges){
        int answer=0;
        boolean[] check = new boolean[n];
        boolean[][] con = new boolean[n][n];

        for (int i = 0; i < edges.length; i++) {
            con[edges[i][0]-1][edges[i][1]-1]= true;
            con[edges[i][1]-1][edges[i][0]-1]= true;
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                for (int j = 0; j < n; j++) {
                    if (!check[i] && con[i][node]){
                        check[i] = true;
                        queue.add(i);
                    }
                }
            }
            answer= size;
        }
        return answer;
    }
    
}
