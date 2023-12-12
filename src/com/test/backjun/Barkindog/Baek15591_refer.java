package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//https://www.acmicpc.net/source/67418851
public class Baek15591_refer {

	static int[] parent; // 이건 union find를 위한 용도
	static int[] rank; // 이 값의 의미를 잘 모르겠다.
	static class Edge implements Comparable<Edge>{
		int start;
		int end;
		int usado;
		
		public Edge(int p, int q, int r) {
			this.start = p;
			this.end = q;
			this.usado = r;
		}
		
		@Override
		public int compareTo(Edge o) { // 유사도 값을 내림차순 정렬
			return o.usado - this.usado;
		}
	}
	
	static class Query implements Comparable<Query> {
		int idx;
		int usado;
		int startNode;
		
		public Query(int idx, int k, int v) {
			this.idx = idx;
			this.usado = k;
			this.startNode = v;
		}
		
		@Override
		public int compareTo(Query o) { // 검색할 유사도를 내림차순으로 정렬
			return o.usado - this.usado;
		}
	}
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		parent = new int[N];
		rank = new int[N];
		
		Edge[] edge = new Edge[N - 1];
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken()) - 1;
			int q = Integer.parseInt(st.nextToken()) - 1;
			int r = Integer.parseInt(st.nextToken());
			
            parent[i] = i;
            rank[i] = 1;
			edge[i] = new Edge(p, q, r);
		}
        
        parent[N - 1] = N - 1;
        rank[N - 1] = 1;
		
		Query[] query = new Query[Q];
		for (int i = 0; i < Q; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken()) - 1;
			
			query[i] = new Query(i, k, v);
		}
		
		Arrays.sort(edge);
		Arrays.sort(query);
		
		int[] res = new int[Q];
		int idx = 0;
        for (Query q : query) {
			
			while(idx < N - 1 && edge[idx].usado >= q.usado) {
				union(edge[idx].start , edge[idx].end);
				idx++;
			}
			res[q.idx] = rank[find(q.startNode)] - 1;
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			sb.append(res[i]).append("\n");
		}
		System.out.println(sb);
	}
	
	private static void union(int p, int q) {
		
		int pp = find(p);
		int pq = find(q);
		
		if(pp == pq) return;
        if(rank[pp] >= rank[pq]) {
            parent[pq] = pp;
    		rank[pp] += rank[pq];
        } else {
            parent[pp] = pq;
            rank[pq] += rank[pp];
        }
		
	}

	private static int find(int p) {
		if(parent[p] == p) return p;
		return parent[p] = find(parent[p]);
	}

}