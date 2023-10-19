package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baek5397 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Stack<Character> front = new Stack<>();
            Stack<Character> rear = new Stack<>();
            String line = reader.readLine();
            for (int idx = 0; idx < line.length(); idx++) {
                char now = line.charAt(idx);
                if(now=='-'){
                    if(!front.empty()){
                        front.pop();
                    }
                }else if(now =='<'){
                    if(!front.empty()){
                        rear.add(front.pop());
                    }
                }else if(now =='>'){
                    if(!rear.isEmpty()){
                        front.add(rear.pop());
                    }
                }else{
                    front.add(now);
                }
            }
            while(!front.isEmpty()){
                rear.add(front.pop());
            }
            while(!rear.isEmpty()){
                sb.append(rear.pop());
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        // getSb(reader, n);
    }

    // stringbuilder 또는 linkedlist로 작업하니 실패했다...
    private static void getSb(BufferedReader reader, int n) throws IOException {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            StringBuilder temp = new StringBuilder();
            int idx = 0;
            for (int j = 0; j < line.length(); j++) {
                char now = line.charAt(j);
                if(now=='-'){
                    idx = idx - 1 >= 0 ? idx -1 : 0;
                    if(temp.length()> idx){
                        temp.deleteCharAt(idx);
                    }
                }else if(now =='>'){
                    idx = idx +1 > temp.length() -1 ? idx : idx +1;
                }else if(now =='<'){
                    idx = idx -1 < 0 ? 0 : idx - 1;
                }else{
                    temp.insert(idx,now);
                    idx+=1;
                }
            }
            sb.append(temp);
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

}
