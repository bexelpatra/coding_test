package com.test.backjun;

import java.util.*;
import java.io.*;

//https://www.acmicpc.net/source/9981863
// 샘플 데이터를 넣어두고 진행한게 흥미롭다.
public class Baek1068_refer {
	static int N, root, del, ans;
	static int[] node; 
	static boolean[] visit, leaf;

	public static void main(String[] args) throws Exception {		
		System.setIn(new FileInputStream("d:/baek.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		node = new int[N];
		visit = new boolean[N];
		leaf = new boolean[N];
		Arrays.fill(leaf, true);
		
		String in[] = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			node[i] = Integer.parseInt(in[i]);
			if (node[i] == -1) root = i;
		}		
		del = Integer.parseInt(br.readLine());
		visit[del] = true;
		
		ans = 0;
		dfs(root);
		System.out.println(ans);
	}
	
	static void dfs(int idx) {
		if (visit[idx]) return;
		visit[idx] = true;
		for (int i = 0; i < N; i++) {
			if (i == root) continue;
			if (node[i] == idx && !visit[i]) {
				//System.out.println("idx -> i : "+idx+" "+i);
				leaf[idx] = false;
				dfs(i);
			}
		}
		if (leaf[idx]) ans++;
	}
}	
