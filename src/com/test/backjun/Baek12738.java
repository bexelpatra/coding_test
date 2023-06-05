package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12738 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		int[] list = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int listIdx = 1;
		list[0] = arr[0];
		for (int i = 1; i < n; i++) {
			if (list[listIdx - 1] < arr[i]) {
				list[listIdx] = arr[i];
				listIdx += 1;
			} else {
				int lo = 0;
				int hi = listIdx;
				while(lo<hi) {
					int mid = (hi+lo)/2;
					if(list[mid]<arr[i]) {
						lo = mid+1 ;
					}else {
						hi = mid ;
					}
				}
				list[lo] = arr[i];
			}
			
		}
		System.out.println(listIdx);
	}
}