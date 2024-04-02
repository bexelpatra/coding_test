package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek5567 {
    static boolean[][] friends;
    static boolean[] invited;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        invited = new boolean[n+1];
        friends = new boolean[n+1][n+1];
        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends[a][b] = true;
            friends[b][a] = true;
        }
        bfs(1);
        int count = 0;
        for (boolean is : invited) {
            if(is) count+=1;
        }
        System.out.println(count-1);

    }
/**
 * 
6
5
1 2
1 3
3 4
2 3
4 5
 * @param start
 */
    static void bfs(int start){
        Queue<int[]> q = new LinkedList<>();
        invited[start] = true;
        q.add(new int[]{start,0}); // 본인

        while(!q.isEmpty()){
            int[] now = q.poll();
            int name = now[0];
            int distance = now[1];
            for (int i = 0; i < friends[name].length ; i++) {
                if(friends[name][i] && !invited[i] && distance <2){
                    invited[i] = true;
                    q.add(new int[]{i,distance+1});
                }
            }
        }

    }
}
