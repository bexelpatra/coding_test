package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Baek14888 {

		static int[] arr;
		static int max = Integer.MIN_VALUE;
		static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		arr = new int[N];
		int[] calc = new int[4];
		int[] calc2 = new int[N-1];
		StringTokenizer st = null;
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < calc.length; i++) {
			calc[i] = Integer.parseInt(st.nextToken());
		}
		int k =0;
		for (int i = 0; i < calc.length; i++) {
			 for (int j = 0; j < calc[i]; j++) {
				calc2[k] = i;
				k+=1;
			}
		}
		
//		System.out.println(Arrays.toString(calc2));
		combi(calc2, new int[N-1], new boolean[N-1], 0);
		StringBuilder sb= new StringBuilder();
		sb.append(max);
		sb.append("\n");
		sb.append(min);
		System.out.println(sb.toString());
	}
	
	public static void combi(int[] order,int[] result, boolean[] visited,int idx) {
		if(order.length == idx) {
//			System.out.println(Arrays.toString(result));
			doJob(result);
			return;
		}
		for (int i = 0; i < result.length; i++) {
			if(!visited[i]) {
				visited[i] = true;
				result[idx] = order[i];
				combi(order, result, visited, idx+1);
				visited[i] = false;				
			}
		}
	}
	public static void doJob(int[] result) {
		int yes = arr[0] ;
		for (int i = 1; i < arr.length; i++) {
			switch (result[i-1]) {
			case 0:
				yes+= arr[i];
				break;
			case 1:
				yes-= arr[i];
				break;
			case 2:
				yes*= arr[i];
				break;
			case 3:
				yes/= arr[i];
				break;
			default:
				break;
			}
		}
		min = Math.min(yes, min);
		max= Math.max(yes, max);
	}
}
