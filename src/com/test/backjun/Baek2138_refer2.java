package com.test.backjun;


import java.util.Scanner;

// https://velog.io/@jkh9615/%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-2138-%EC%A0%84%EA%B5%AC%EC%99%80-%EC%8A%A4%EC%9C%84%EC%B9%98-Java
// 순차적으로
public class Baek2138_refer2  {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans1 = 1, ans2 = 0, INF = 987654321;
		String now = sc.next();
		String expect = sc.next();
		
		int[] now_arr_1 = new int[n];
		int[] now_arr_2 = new int[n];
		int[] expect_arr = new int[n];
		
		for(int i = 0; i < n; i++) {
			now_arr_1[i] = now.charAt(i)-'0';
			now_arr_2[i] = now.charAt(i)-'0';
			expect_arr[i] = expect.charAt(i)-'0';
		}
		now_arr_1[0] = 1-now_arr_1[0];
		now_arr_1[1] = 1-now_arr_1[1];
				
		for(int i = 1; i < n; i++) {
			if(now_arr_1[i-1] != expect_arr[i-1]) {
				now_arr_1[i-1] = 1 - now_arr_1[i-1];
				now_arr_1[i] = 1 - now_arr_1[i];
				ans1++;
				if(i != n-1)
					now_arr_1[i+1] = 1 - now_arr_1[i+1];						
				
			}
			if(now_arr_2[i-1] != expect_arr[i-1]) {
				now_arr_2[i-1] = 1 - now_arr_2[i-1];
				now_arr_2[i] = 1 - now_arr_2[i];
				ans2++;
				if(i != n-1)
					now_arr_2[i+1] = 1 - now_arr_2[i+1];		
			}
		}

		if(now_arr_1[n-1] != expect_arr[n-1]) ans1 = INF;
		if(now_arr_2[n-1] != expect_arr[n-1]) ans2 = INF;
		
		
		if(ans1 == INF && ans2 == INF)
			System.out.println(-1);
		else
			System.out.println(Math.min(ans1, ans2));
	}
}