package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek1092 {

	public static void main(String[] args) throws Exception{
//		System.out.println("letgo");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		sol1(reader);
		sol2(reader);
	}

	private static void sol2(BufferedReader reader) throws Exception{
		// TODO Auto-generated method stub
		StringTokenizer st = null;
		int N = Integer.parseInt(reader.readLine());
		Integer[] cranes = new Integer[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < cranes.length; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(reader.readLine());
		List<Integer> list = new ArrayList<>();
		Integer[] boxes = new Integer[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < boxes.length; i++) {
			int temp = Integer.parseInt(st.nextToken());
			boxes[i] = temp;
			list.add(temp);
		}
		Arrays.sort(cranes,Collections.reverseOrder());
		Collections.sort(list, Collections.reverseOrder());
		
		int count =0;
		while(list.size()!=0) {
			boolean flag = true;
			for (int i = 0; i < cranes.length; i++) {
				if(list.size()==0) {
					break;
				}
				a: for (int j = 0; j < list.size(); j++) {
					if(cranes[i] >= list.get(j)) {
						list.remove(j);
						flag = false;
						break a;
					}
				}
				if(flag) {
					System.out.println(-1);
					return;
				}
				
			}
			count+=1;
		}
		System.out.println(count);
	}

	// failed
	// 가벼운것 먼저 싣다보면 최적의 짐을 실지 못한다.
	/*
3
10 6 5
11
6 6 6 6 6 8 8 8 9 9 9
	 */
	private static void sol1(BufferedReader reader) throws IOException {
		StringTokenizer st = null;
		int N = Integer.parseInt(reader.readLine());
		int[] cranes = new int[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < cranes.length; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(reader.readLine());
//		Deque<Integer> q = new ArrayDeque<>();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] boxes = new int[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < boxes.length; i++) {
			int temp = Integer.parseInt(st.nextToken());
			boxes[i] = temp;
			pq.add(temp);
		}
		Arrays.sort(cranes);
		Arrays.sort(boxes);
		
		int count =0;
//		int i=0;
		while(!pq.isEmpty()) {
			for (int i=0; i < cranes.length; i++) {
				if(pq.isEmpty()) {
					break;
				}
				if(cranes[i]>=pq.peek()) {
					pq.poll();
				}else if(i == N-1 && cranes[i]<pq.peek()) {
					System.out.println(-1);
					return;
				}
			}
			count+=1;
		}
		
		System.out.println(count);
	}
}
