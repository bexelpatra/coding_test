package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://st-lab.tistory.com/285
// 11053을 binary search를 이용해서 풀이한다.
public class Baek12015 {

	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(reader.readLine());
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int[] list = new int[n];
		int listIndex = 1;
		list[0] =  arr[0];
		
		for (int i = 1; i < n; i++) {
			int key = arr[i];
			if(list[listIndex-1] < key) {
				list[listIndex] = key;
				listIndex+=1;
			}else {
				int lo = 0 ;
				int hi = listIndex;
				while(lo < hi) {
					int mid = (hi+lo)/2;
					if(list[mid]<key) {
						lo = mid+1;
					}else {
						hi = mid;
					}
				}
				list[lo] = key;
			}
		}
		System.out.println(listIndex);
		
	}
}
