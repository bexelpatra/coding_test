package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 최소 스패닝 트리
// 크루스칼 알고리즘, 프림 알고리즘
public class Baek1197_refer {
    // 프림
    static int total;
	static List<PrimNode>[] primList;
	static boolean[] visited;

	static class PrimNode implements Comparable<PrimNode>{
		int to;
		int value;
		
		public PrimNode(int to, int value) {
			this.to = to;
			this.value = value;
		}

		@Override
		public int compareTo(PrimNode o) {
			return this.value - o.value;
		}
	}

    // 크루스칼(합집합)
	static int[] parent;
    static class KruskalNode implements Comparable<KruskalNode>{
		int to;
		int from;
		int value;
		
		public KruskalNode(int to, int from, int value) {
			this.to = to;
			this.from = from;
			this.value = value;
		}

		@Override
		public int compareTo(KruskalNode o) {
			return this.value - o.value;
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // kruskal(reader);
        prim(reader);
    }

    public static void prim(BufferedReader reader) throws IOException{
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        primList = new List[v+1];
        visited = new boolean[v+1];

        for (int i = 0; i < primList.length; i++) {
            primList[i] = new ArrayList<>();
        }
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            
            primList[from].add(new PrimNode(to, value));
            primList[to].add(new PrimNode(from, value));
        }

        PriorityQueue<PrimNode> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));
        pq.add(new PrimNode(1, 0));
        int result = 0;
        while(!pq.isEmpty()){
            PrimNode now = pq.poll();
            int to = now.to;
            int value = now.value;

            if(visited[to]){
                continue;
            }
            visited[to] = true;
            result+= value;
            for (PrimNode primNode : primList[to]) {
                if(!visited[primNode.to]){
                    pq.add(primNode);
                }
            }
        }
        System.out.println(result);

    }
    public static void kruskal(BufferedReader reader) throws IOException{
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        parent = new int[v+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i]=i;
        }
        List<KruskalNode> list = new ArrayList<>();
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(reader.readLine());
            list.add(new KruskalNode(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((o1, o2) -> o1.compareTo(o2) );
        int answer = 0;
        for (int i = 0; i < e; i++) {
            KruskalNode now = list.get(i);
            if(find(now.from)!=find(now.to)){
            // if(!isSameParent(now.from, now.to)){
                union(now.from, now.to);
                answer+= now.value;
            }
        }
        System.out.println(answer);
    }
    static int result = 0;
    public static boolean isSameParent(int x, int y) {
        x = find(x);
        y = find(y);
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }
    // 오히려 느리다...
    public static void fastUnion(int x, int y,int c) {
        x = find(x);
        y = find(y);
        if (x != y) {
          parent[y] = x;
          result+=c;
        } 
    }

    public static void union(int x,int y){
        int xRoot = find(x);
        int yRoot = find(y);
        if(xRoot != yRoot){
            parent[yRoot] = xRoot;
        }
    }
    public static int find(int x){
        if(parent[x] == x){
            return x;
        }
        return find(parent[x]);
    }
}
