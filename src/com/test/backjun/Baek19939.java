package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 쉬운데 몇번 틀리고 넘어갔다...
 * 결과를 조금더 생각하고 작성해보자.
 */
public class Baek19939 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int temp = k;
        int min = 0;
        while(temp>0){
            min +=temp--;
        }
        System.out.println(min);
        if(n<min){
            System.out.println(-1);
            return;
        }else{
            int left = (n - min) % k >0 ? 1 : 0;
            left += k -1;
            System.out.println(left);
        }
    }
}
