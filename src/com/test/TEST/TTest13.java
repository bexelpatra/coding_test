package com.test.TEST;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class TTest13 {
    public static void main(String[] args) {
        String temp = "1234";
        int x = 123;
        ;
        System.out.println(Integer.toString(3333,4));
        System.out.println("왜 안나옴?");
        System.out.println((char)('\307'));
        
        System.out.println((char)('\003'));
        System.out.println((char)('\020'));
        System.out.println((char)('\001'));
        System.out.println((char)('\032'));

        

        
        combi(new int[3], new boolean[arr.length], 0, 0);
        
        
    }
    static int[] arr = new int[]{1,2,3,4,5,6};
    public static void combi(int[] result, boolean[] visited,int idx ,int start){
        if(idx == result.length ){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = start; i < arr.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx]= arr[i];
                combi(result,visited,idx+1,i+1);
                visited[i] = false;
            }
        }
    }
}
