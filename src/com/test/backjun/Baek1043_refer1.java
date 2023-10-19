package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://loosie.tistory.com/463
public class Baek1043_refer1 {

	static int[] parents;
	static List<Integer> know_truth_people;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n+1];
		for(int i=1; i<n+1; i++) {
			parents[i] = i;
		}
		st = new StringTokenizer(br.readLine());
		int know_count= Integer.parseInt(st.nextToken());
		know_truth_people = new ArrayList<>();
		if(know_count==0) {
			System.out.println(m);
			return;
		} else {
			for(int i=0; i<know_count; i++) {
				know_truth_people.add(Integer.parseInt(st.nextToken()));
			}
		}
		
		List<Integer>[] partyList = new ArrayList[m];
		
		for(int i=0; i<m; i++) {
            partyList[i] = new ArrayList<>();
			st = new StringTokenizer(br.readLine());
			int pn = Integer.parseInt(st.nextToken());
			
			int x = Integer.parseInt(st.nextToken());
			partyList[i].add(x);
			for(int j=1; j<pn; j++) {
				int y = Integer.parseInt(st.nextToken());
				union(x,y);
				partyList[i].add(y);
			}
		}
        
		int cnt=0;
		for(int i=0; i<m; i++) {
			boolean flag = true;
			for(int num : partyList[i]) {
				if(know_truth_people.contains(find(parents[num]))) {
                    flag= false;
                    break;
    			}
            }
			if(flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
		
	}
	
	static int find(int x) {
		if(parents[x] ==x ) return x;
		return find(parents[x]);
	}
	
	static void union(int x, int y) {
		int rx = find(x);
		int ry = find(y);
		if(know_truth_people.contains(ry)) {
			int tmp = rx;
			rx = ry;
			ry =tmp;
		}
		
		parents[ry] = rx;
	}
}