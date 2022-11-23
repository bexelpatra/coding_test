package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baek1259 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true){
            String pal = reader.readLine();
            boolean flag = true;
            if (pal.equals("0") ) break;
            a :for (int i = 0; i < pal.length()/2; i++) {
                if (pal.charAt(i)!=pal.charAt(pal.length()-i-1)){
                    flag = false;
                    break a;
                }
            }
            if(flag){
                sb.append("yes");
            }else{
                sb.append("no");
            }
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}
