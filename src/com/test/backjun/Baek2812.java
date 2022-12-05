package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek2812 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //sol1(reader);
        sol2(reader);
//        Deque<Integer> q = new ArrayDeque<>(); // 스택 같은 것 poll 은 머리
//        q.push(1);
//        q.push(2);
//        q.push(3);

//        q.push(4);
//        q.push(5);
//
//        System.out.println(q.poll());
//        System.out.println(q.pollLast());
//
    }

    private static void sol2(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] target =  reader.readLine().toCharArray();
        int finish = N-K;
        Deque<Integer> q = new ArrayDeque<>();
        int i=0;
        while(finish!=q.size()){
            if (i ==N){
                break;
            }
            if(K==0){
                q.push(target[i]-'0');
                i++;
                continue;
            }
            if(q.isEmpty()){
                q.push(target[i]-'0');
            }else{
                if(q.peek() <target[i]-'0'){
                    q.poll();
                    q.push(target[i]-'0');
                    K-=1;
                }else{
                    q.push(target[i]-'0');
                }
            }
            i+=1;
        }
        StringBuilder sb = new StringBuilder();
        while(!q.isEmpty()){
            sb.append(q.pollLast());
        }
        System.out.println(sb.toString());

    }

    // timeout...
    private static void sol1(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int end = N-K;
        char[] target =  reader.readLine().toCharArray();
        List<Integer> list = new ArrayList<>();
        int start =0;
        int targetVal = -1;
        int targetIdx = -1;

        while(list.size()!=end) {
            for (int i = start; i <= start+K; i++) {
                if(i > N-1) {
                    break;
                }
                if (target[i] > targetVal) {
                    targetVal = target[i];
                    targetIdx = i;
                }
            }
            list.add(target[targetIdx]-'0');
            K -= (targetIdx-start);
            start = targetIdx+1;
            targetVal =-1;

        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
        }

        System.out.println(sb.toString());
    }

}
