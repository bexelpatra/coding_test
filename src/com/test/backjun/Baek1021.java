package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        Deque<Integer> dq = new LinkedList<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] nums = new int[m];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            dq.push(i+1);
        }
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            Iterator<Integer> it = dq.iterator();
            int idx = index(it, nums[i]);

            // dq 길이와 비교해서 좌로갈지 우로갈지 정해야 한다.
            if(dq.size()/2<idx){
                dq.addFirst(dq.pollLast());
            }
        }
        
    }
    public static int index(Iterator<Integer> it, int target){
        int idx = 0;
        while(it.hasNext()){
            if(it.next() == target){
                break;
            }
            idx+=1;
        }
        return idx;
    }
}
