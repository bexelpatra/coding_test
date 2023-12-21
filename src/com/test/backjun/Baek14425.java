package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st=  new StringTokenizer(reader.readLine());
        int s = Integer.parseInt(st.nextToken());
        int checkListCount = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>(s);
        for (int i = 0; i < s; i++) {
            set.add(reader.readLine());
        }
        int result = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < checkListCount; i++) {

            // 1. contain 사용
            // if(set.contains(reader.readLine())){
            //     result +=1;
            // }

            // 2. set의 size 사용
            String temp = reader.readLine();
            
            set.add(temp);
            if(set.size()!= s){
                set.remove(temp);
            }else{
                sb.append(temp).append("\n");
                result+=1;
            }
        }
        System.out.println(result);
        System.out.println(sb.toString());
    }
}
