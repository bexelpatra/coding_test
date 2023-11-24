package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;


// linkedlist를 사용하게 될 줄은 몰랐다...
// ArrayDeque에는 없는 기능들도 포함되어 있다.
public class Baek1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int t =  Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dq.offer(i+1);
        }
        int[] target = new int[t];

        int count = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < target.length; i++) {
            boolean head = headOrTail(dq, target[i]);

            if(head){
                while(true){
                    int now = dq.pollFirst();
                    if(now==target[i]){
                        break;
                    }
                    count+=1;
                    dq.addLast(now);
                }
            }else{
                while(true){
                    int now = dq.pollLast();
                    count+=1;
                    if(now==target[i]){
                        break;
                    }
                    dq.addFirst(now);
                }
            }
        
            // System.out.println(Arrays.toString(dq.toArray()));
            // System.out.println(count);
        }
        System.out.println(count);
        // useLinkedList();
    }
    private static boolean headOrTail(LinkedList<Integer> list, int target){
        int len = list.size();
        if(len %2==0){
            len /=2;
            len -=1;
        }else{
            len /=2;
        }
        for (int i = 0; i <= len; i++) {
            if(list.get(i)==target){
                return true;
            }
        }
        return false;
    }
    private static void useLinkedList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n  = Integer.parseInt(st.nextToken());
        int t =  Integer.parseInt(st.nextToken());
        
        LinkedList<Integer> dq = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            dq.offer(i+1);
        }
        int[] target = new int[t];

        int count = 0;
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < target.length; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < target.length; i++) {
            int idx = dq.indexOf(target[i]);
            int half = dq.size()/2;
            if(dq.size() %2==0){
                half -=1;
            }
            if(idx <= half){
                for (int j = 0; j < idx; j++) {
                    int first = dq.pollFirst();
                    dq.addLast(first);
                    count+=1;
                }
            }else{
                for (int j = 0; j <dq.size()-idx ; j++) {
                    int last = dq.pollLast();
                    dq.addFirst(last);
                    count+=1;
                }
            }
            // System.out.println(Arrays.toString(dq.toArray()));
            // System.out.printf("count %d , idx %d, half %d \n\n",count,idx,half);
            
            dq.pollFirst();
        }
        System.out.println(count);
    }
}
