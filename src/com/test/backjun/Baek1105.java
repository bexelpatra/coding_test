package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1105 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        String l= st.nextToken();
        String r= st.nextToken();
        if(l.length() !=r.length()){
            System.out.println(0);
            return;
        }
        int result = 0;
        for (int i = 0; i < l.length(); i++) {
            if(l.charAt(i)==r.charAt(i) && l.charAt(i)=='8'){
                result+=1;
            }else if(l.charAt(i)!=r.charAt(i)){
                break;
            }
        }
        System.out.println(result);
    }
}
