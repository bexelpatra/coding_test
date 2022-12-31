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

    }
    //https://steady-coding.tistory.com/54
    private static void sol4(BufferedReader reader) throws IOException{
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] target =  reader.readLine().toCharArray();
        Deque<Character> dq = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length; i++) {
            while (K > 0 && !dq.isEmpty() && dq.getLast() < target[i]) {
                dq.removeLast();
                K--;
            }
            dq.addLast(target[i]);
        }
        while (dq.size() > K) {
            sb.append(dq.removeFirst());
        }
        System.out.println(sb.toString());
    }


    // 75% 가량에서 틀린다...
    private static void sol2(BufferedReader reader) throws IOException {
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] target =  reader.readLine().toCharArray();
        int finish = N-K;
        Deque<Integer> q = new ArrayDeque<>();
        int i=0;
        while(i<N){

            if(K==0){
                q.push(target[i]-'0');
                i++;
                continue;
            }
            if(q.isEmpty()){
                q.push(target[i]-'0');
            }else{
                while(q.peek() <target[i]-'0' && K>0){
                    q.poll();
                    K-=1;
                    if(q.isEmpty()) break;
                }
                q.push(target[i]-'0');
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
    //https://velog.io/@solser12/%EB%B0%B1%EC%A4%80-2812-%ED%81%AC%EA%B2%8C-%EB%A7%8C%EB%93%A4%EA%B8%B0-JAVA
    public static void sol3() throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();

        Stack stack = new Stack(N);
        int count = 0;
        for (int i = 0; i < N; i++) {
            int num = input.charAt(i) - '0';

            if (!stack.isEmpty()) {
                while (!stack.isEmpty() && count < K) {
                    if (stack.peek() < num) {
                        stack.pop();
                        count++;
                    } else {
                        break;
                    }
                }
            }

            stack.push(num);

            if (count == K) {
                sb.append(input.substring(i+1));
                break;
            }
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            if (count < K) {
                count++;
                continue;
            }
            sb.insert(0, num);
        }

        System.out.println(sb);

        br.close();
    }

    public static class Stack {
        int[] arr;
        int idx;

        public Stack(int size) {
            this.arr = new int[size];
        }

        public void push(int num) {
            arr[idx++] = num;
        }

        public boolean isEmpty() {
            return idx == 0;
        }

        public int peek() {
            return arr[idx -1];
        }

        public int pop() {
            return arr[--idx];
        }
    }
}
