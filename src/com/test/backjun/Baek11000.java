package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Baek11000 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] lecture = new int[n][2];
        StringTokenizer st;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1]-o2[1]);
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            lecture[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        // 강의를 시간 순서대로 정렬
        Arrays.sort(lecture, (o1, o2) -> {
            if(o1[0]==o2[0]){
                return o1[1]-o2[1];
            }
            return o1[0]-o2[0];
        });
        pq.add(lecture[0]);

        // 강의 끝나는 순서대로 우선순위 정렬
        for (int i = 1; i < lecture.length; i++) {
            if(!pq.isEmpty()){
                System.out.printf("pq : %d -> %d    now : %d -> %d \n",pq.peek()[0],pq.peek()[1],lecture[i][0],lecture[i][1]);
            }
            if(!pq.isEmpty() &&pq.peek()[1]<= lecture[i][0]){
                pq.poll();
            }
            pq.add(lecture[i]);
        }

        System.out.println(pq.size());
    }
}
