package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek18310 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		sol2(reader);
	}

	// 틀림...
	// 평균을 구하고 평균에서 가장 가까운 집을 찾는 방식으로 접근
	// 반례 1 1 3 100 1000 답은 3인데 100을 도출
	private static void sol1(BufferedReader reader) throws IOException {
		StringTokenizer st = null;	
		int n = Integer.parseInt(reader.readLine());
		int[] zips = new int[100_001];
		st = new StringTokenizer(reader.readLine());
		long sum = 0;
		for (int i = 0; i < n; i++) {
			int now = Integer.parseInt(st.nextToken());
			sum +=now;
			zips[now] +=1 ;
		}
		sum /=n;
		
		int ans =0;
		if(zips[(int)sum]!=0) {
			ans = (int)sum;
		}else {
			int left = (int)sum;
			while(left >0 && zips[left]==0) {
				left --;
			}
			int right = (int)sum;
			while(right < 100_001 && zips[right]==0) {
				right++;
			}
			
			if((int)sum - left <= right-(int)sum) {
				ans = left;
			}else {
				ans = right;
			}
		}
		
		System.out.println(ans);
	}
	
	private static void sol2(BufferedReader reader) throws IOException {
		StringTokenizer st = null;	
		int n = Integer.parseInt(reader.readLine());
		int[] zips = new int[n+1];
		st = new StringTokenizer(reader.readLine());
		
		for (int i = 0; i < n; i++) {
			zips[n] =Integer.parseInt(st.nextToken()) ;
		}
		Arrays.sort(zips);
		System.out.println(zips[(n-1)/2]);
	}
}
