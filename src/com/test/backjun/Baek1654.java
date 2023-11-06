package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1654 implements BaekImpl<Long>{
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] lines = new int[n];

        long min = 0;
        long max = 0;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = Integer.parseInt(reader.readLine());
            if(max < lines[i]){
                max = lines[i];
            }
        }

        while(min < max){
            long mid = (max+min) /2;
            if(mid ==0 ) {
                mid = 1;
            }
            long temp = 0;
            for (int line : lines) {
                temp += line/mid;
            }
            if(temp < target){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        System.out.println(min-1);
    }
    @Override
    public Long getResult(BufferedReader reader) {
        // TODO Auto-generated method stub
        StringTokenizer st;
        try {
        st = new StringTokenizer(reader.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] lines = new int[n];

        long min = 0;
        long max = 0;
        for (int i = 0; i < lines.length; i++) {
            lines[i] = Integer.parseInt(reader.readLine());
            if(max < lines[i]){
                max = lines[i];
            }
        }

        while(min < max){
            long mid = (max+min) /2;
            if(mid ==0 ) {
                mid = 1;
            }
            int temp = 0;
            for (int line : lines) {
                temp += line/mid;
            }
            if(temp < target){
                max = mid;
            }else{
                min = mid+1;
            }
        }
        return min-1;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
