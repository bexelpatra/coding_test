package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1969 {
	static char[] cha = new char[]{'A','C','G','T'};
	
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(reader.readLine());
		int n = Integer.parseInt(st.nextToken());
		int len = Integer.parseInt(st.nextToken());
		int[][] ACGT = new int[len][4];
		
		for (int i = 0; i < n; i++) {
			String now = reader.readLine();
			for (int j = 0; j < now.length(); j++) {
				for (int k = 0; k < cha.length; k++) {
					if(now.charAt(j) == cha[k]) {
						ACGT[j][k]+=1;
						break;
					}
				}
//				if(now.charAt(j)=='A') {
//					ACGT[i][0]+=1;
//				}else if(now.charAt(j)=='C') {
//					ACGT[i][1]+=1;
//				}else if(now.charAt(j)=='G') {
//					ACGT[i][2]+=1;
//				}else {
//					ACGT[i][3]+=1;
//				}
			}
		}
		// a c g t
		StringBuilder sb = new StringBuilder();
		int sum =0;
		for (int i = 0; i < ACGT.length; i++) {
			int[] js =getMax(ACGT[i]);
			sb.append((char)js[0]);
			sum+= js[1];
		}
		System.out.println(sb.toString());
		System.out.println(n*len-sum);
	}
	
	public static int[] getMax(int[] arr) {
		int idx = -1;
		int max = -1;
		for (int i = 0; i < arr.length; i++) {
			int j = arr[i];
			if(j>max) {
				max = j;
				idx = i;
			}
		}
		return new int[]{cha[idx],max};
	}
}
