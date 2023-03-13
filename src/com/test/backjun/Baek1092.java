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

	public static void main(String[] args) throws Exception {
//		System.out.println("letgo");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//		sol1(reader);
		sol2(reader);
		sol3(reader);
//		sol4(reader);
	}
	//https://code-lab1.tistory.com/106
	private static void sol4(BufferedReader reader) throws Exception{
		// TODO Auto-generated method stub
				StringTokenizer st = null;
				int N = Integer.parseInt(reader.readLine());
				Integer[] cranes = new Integer[N];
				st = new StringTokenizer(reader.readLine());
				for (int i = 0; i < cranes.length; i++) {
					cranes[i] = Integer.parseInt(st.nextToken());
				}
				int n = Integer.parseInt(reader.readLine());
				List<Integer> box = new ArrayList<>();
				Integer[] boxes = new Integer[n];
				st = new StringTokenizer(reader.readLine());
				for (int i = 0; i < boxes.length; i++) {
					box.add(Integer.parseInt(st.nextToken()));
				}
				Arrays.sort(cranes, Collections.reverseOrder());
				Collections.sort(box, Collections.reverseOrder());
				if(cranes[0]<box.get(0)) {
					System.out.println(-1);
					return;
				}
				
				int day = 0;
				while (box.size() != 0) {
					int boxIdx = 0;
					for (int i = 0; i < cranes.length;) {
						if(boxIdx == box.size()) break;
						if (cranes[i] >= box.get(boxIdx)) {
							box.remove(boxIdx);
							i++;
						}else {
							boxIdx++;
						}
					}
					day += 1;
				}
				System.out.println(day);
	}

	//https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-1092%EB%B2%88-%EB%B0%B0-java
	private static void sol3(BufferedReader reader) throws Exception {
		int N = Integer.parseInt(reader.readLine());
		List<Integer> crane = new ArrayList<>();

		StringTokenizer st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < N; i++)
			crane.add(Integer.parseInt(st.nextToken()));

		int M = Integer.parseInt(reader.readLine());
		List<Integer> box = new ArrayList<>();

		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < M; i++)
			box.add(Integer.parseInt(st.nextToken()));

		// 내림차순으로 정렬
		crane.sort(Collections.reverseOrder());
		box.sort(Collections.reverseOrder());

		if (crane.get(0) < box.get(0)) {
			System.out.println(-1);
			return;
		}

		int day = 0;
		int count = 0;
		while (!box.isEmpty()) {
			int boxIdx = 0, craneIdx = 0;

			while (craneIdx < N) {
				count++;
				if (boxIdx == box.size())
					break;
				else if (crane.get(craneIdx) >= box.get(boxIdx)) {
					box.remove(boxIdx);
					craneIdx++;
				} else
					boxIdx++;
			}

			day++;
		}

		System.out.println(day);
		System.out.println("count is "+count);
	}
	// failed... time over
	private static void sol2(BufferedReader reader) throws Exception {
		// TODO Auto-generated method stub
		StringTokenizer st = null;
		int N = Integer.parseInt(reader.readLine());
		Integer[] cranes = new Integer[N];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < cranes.length; i++) {
			cranes[i] = Integer.parseInt(st.nextToken());
		}
		int n = Integer.parseInt(reader.readLine());
		List<Integer> box = new ArrayList<>();
		Integer[] boxes = new Integer[n];
		st = new StringTokenizer(reader.readLine());
		for (int i = 0; i < boxes.length; i++) {
			box.add(Integer.parseInt(st.nextToken()));
		}
		Arrays.sort(cranes, Collections.reverseOrder());
		Collections.sort(box, Collections.reverseOrder());
		if(cranes[0]<box.get(0)) {
			System.out.println(-1);
			return;
		}
		
		int day = 0;
		int count = 0;
		while (box.size() != 0) {
			for (int i = 0; i < cranes.length; i++) {
				for (int boxIdx = 0; boxIdx < box.size(); boxIdx++) {
					count++;
					if (cranes[i] >= box.get(boxIdx)) {
						box.remove(boxIdx);
						break;
					}
				}
			}
			day += 1;
		}
		System.out.println(day);
		System.out.println("count is "+count);

	}

	// failed
	// 가벼운것 먼저 싣다보면 최적의 짐을 실지 못한다.
	/*
	 * 3 10 6 5 11 6 6 6 6 6 8 8 8 9 9 9
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

		int count = 0;
//		int i=0;
		while (!pq.isEmpty()) {
			for (int i = 0; i < cranes.length; i++) {
				if (pq.isEmpty()) {
					break;
				}
				if (cranes[i] >= pq.peek()) {
					pq.poll();
				} else if (i == N - 1 && cranes[i] < pq.peek()) {
					System.out.println(-1);
					return;
				}
			}
			count += 1;
		}

		System.out.println(count);
	}
}
