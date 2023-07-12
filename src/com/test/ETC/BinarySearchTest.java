package com.test.ETC;

import java.util.Arrays;

public class BinarySearchTest {

	public static void main(String[] args) {
//		int[] arr= new int[] {10, 20, 30, 15, 20, 30, 50, 40, 45 ,60};
		int[] arr= new int[] {1,2,3,6,8,9,10,15,17,22,27};
		int lo = 0;
		int hi = arr.length-1;
		
		System.out.println(Arrays.binarySearch(arr, 22));
		int key = 17;
		while(lo < hi) {
			System.out.println(lo +" : "+ hi);
			int mid = (hi+lo)/2;
			if(arr[mid] < key ) {
				lo = mid +1;
			}else {
				hi = mid;
			}
		}
		System.out.println(arr[lo]);
	}
}
