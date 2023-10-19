package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 실패...
// 플로이드 와샬로 파티 참여자를 연결하려고 했지만 안된다.
public class Baek1043 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        // if(st.countTokens()==1){
        //     System.out.println(m);
        //     return;
        // }
        int people = Integer.parseInt(st.nextToken());
        // int[] truths = new  int[people];
        List<Integer> truths = new ArrayList<>();
        for (int i = 0; i < people; i++) {
            truths.add(Integer.parseInt(st.nextToken()));
        }
        List<int[]> parties = new ArrayList<>();
        boolean[][] meet = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] temp = new int[len];
            for (int j = 0; j < len; j++) {
                int now = Integer.parseInt(st.nextToken());
                temp[j] = now;
            }
            parties.add(temp);
            for (int j = 0; j < len; j++) {
                for (int j2 = 0; j2 < len; j2++) {
                    if(j==j2){
                        continue;
                    }
                    meet[temp[j]][temp[j2]] = true;
                    meet[temp[j2]][temp[j]] = true;
                }
            }
        }
        // 거쳐
        for (int inter = 0; inter < meet.length; inter++) {
            // 시작
            for (int start = 0; start < meet.length; start++) {
                // 종점
                for (int end = 0; end < meet.length; end++) {
                    if((meet[start][inter] && !meet[inter][end] )||(!meet[start][inter] && meet[inter][end])){
                        meet[start][inter] = true;
                        meet[inter][start] = true;

                        meet[end][inter] = true;
                        meet[inter][end] = true;

                        meet[start][end] = true;
                        meet[end][start] = true;
                    }
                    for (boolean[] bs : meet) {
            System.out.println(Arrays.toString(bs));
        }
        System.out.println();
                }
            }
        }


        for (boolean[] bs : meet) {
            System.out.println(Arrays.toString(bs));
        }
        boolean[] truths2 = new boolean[n+1];


        for (int i = 0; i < parties.size() ; i++) {
            int[] now = parties.get(i);
            boolean flag = false;
            for (int j = 0; j < now.length; j++) {
                
            }
        }

    }
}
