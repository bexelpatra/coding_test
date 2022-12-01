package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1316 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int answer = 0;
        for (int i = 0; i < n; i++) {
            char[] abc = new char[26];
            char[] now = reader.readLine().toCharArray();
            boolean flag = true;
            if(now.length>1){
                abc[now[0]-'a']+=1;
                abc[now[1]-'a']+=1;
            }
            for (int j = 2; j < now.length; j++) {
                if(now[j-1]!=now[j]){
                    if(abc[now[j]-'a']==0){
                        abc[now[j]-'a']+=1;
                    }else{
                        flag=false;
                        break;
                    }
                }
            }
            if (flag){
                answer+=1;
            }
        }
        System.out.println(answer);
    }
}


