package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P10162 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] T = new int[3];
        int[] result = new int[3];
        StringBuilder sb=  new StringBuilder();
        T[0] = 300;
        T[1] = 60;
        T[2] = 10;

        int time = Integer.parseInt(reader.readLine());

        for (int i = 0; i <T.length; i++) {
            result[i] = time/T[i];
            sb.append(time/T[i]);
            sb.append(" ");
            time= time%T[i];
        }
        sb.deleteCharAt(sb.length()-1);
        if(time > 0){
            System.out.println(-1);
            return;
        }
        System.out.println(sb.toString());

    }
}
