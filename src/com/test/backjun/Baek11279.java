package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Baek11279 {
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(reader.readLine());
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>((o1,o2)->{
			return o2-o1;
		});
		String now = "";
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			now = reader.readLine();
			if("0".equals(now)) {
				Integer x = pq.poll();
				if(x == null) {
					sb.append("0");
				}else {
					sb.append(x);
				}
				sb.append("\n");
			}else {
				pq.add(Integer.parseInt(now));
			}
		}
		reader.close();
		System.out.println(sb.toString());
	}
}
