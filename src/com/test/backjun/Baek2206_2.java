package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//https://iseunghan.tistory.com/316
public class Baek2206_2 {
	 public static void main(String[] args) throws IOException {
	        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(bf.readLine());
	        
	        int N = Integer.parseInt(st.nextToken());
	        int M = Integer.parseInt(st.nextToken());

	        // 시작지점과 도착지점이 같을 경우!
	        if(N-1 == 0 && M-1 == 0){
	            System.out.print(1);
	            System.exit(0);
	        }
	        
	        int[] dx = {1, 0, -1, 0};
	        int[] dy = {0, 1, 0, -1};

	 
	    }
	 public static void print(int[][] c) {
		 for (int i = 0; i < c.length; i++) {
			 
			 System.out.println(Arrays.toString(c[i]));
		}
		 System.out.println();
	 }
}

