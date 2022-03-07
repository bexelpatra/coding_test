package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1260 {

    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] header = new int[3];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 3; i++) {
            header[i] = Integer.parseInt(st.nextToken());
        }
        int nodes = header[0]        ;
        int len = header[1];
        int[][] graph = new int[nodes+1][nodes+1];
        boolean[] passed = new boolean[nodes+1];
        int[] seq = new int[nodes+2];

        for (int i = 0; i < len; i++) {
            StringTokenizer token = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(token.nextToken());
            int b = Integer.parseInt(token.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        getDfs(passed, graph, seq, header[2],0);

        for (int[] nums :graph) {
            System.out.println(Arrays.toString(nums));
        }
        System.out.println(Arrays.toString(seq));

    }

    private static void getDfs(boolean[] passed, int[][] graph, int[] seq, int i,int cnt) {

        if(cnt == graph.length-2) return;
        int[] now = graph[i];
        for (int j =1;j< graph.length;j++){
            if(i!=j){
                if(!passed[j] && now[j]==1){
                    passed[i] = true;
                    seq[cnt] = j;
                    getDfs(passed,graph,seq,j,cnt+1);
                }
            }
        }
    }


}
