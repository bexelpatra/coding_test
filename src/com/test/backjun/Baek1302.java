package com.test.backjun;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Baek1302 {
    public static void main(String[] args) throws Exception {
        // System.setIn(new FileInputStream("d:/baek.txt"));
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        
        List<String> list = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String now = reader.readLine();
            list.add(now);
        }
        Collections.sort(list);
        String now = list.get(0);
        int tmp = 1;
        
        String maxString = now;
        int max = 1;

        for (int i = 1; i < list.size(); i++) {
            
            if(list.get(i).equals(now)){
                tmp +=1;
            }else{
                if(max <tmp){
                    max = tmp;
                    maxString = now;
                }
                now = list.get(i);
                tmp=1;
            }
        }
        if(max < tmp){
            maxString = now;
        }
        System.out.println(maxString);
        
        
        
    }
}
