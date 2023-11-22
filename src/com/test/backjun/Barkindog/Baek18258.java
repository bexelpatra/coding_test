package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Baek18258 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        byDeque(reader, n);
        
    }

    private static void byDeque(BufferedReader reader, int n) throws IOException {
        Deque<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String now = reader.readLine();
            if(now.startsWith("push")){
                q.add(Integer.parseInt(now.split(" ")[1]));
            }else{
                if("pop".equals(now)){
                    if(!q.isEmpty()){
                        sb.append(q.poll()).append("\n");
                    }else{
                        sb.append(-1).append("\n");
                    }
                }else if("size".equals(now)){
                    sb.append(q.size()).append("\n");
                }else if("front".equals(now)){
                    sb.append(q.peekFirst()==null ? -1: q.peekFirst()).append("\n");
                }else if("back".equals(now)){
                    sb.append(q.peekLast() == null ? -1 : q.peekLast()).append("\n");
                }else if("empty".equals(now)){
                    sb.append(q.isEmpty() ? 1:0).append("\n");
                }
            }
        }
        System.out.println(sb.toString());
    }
}
