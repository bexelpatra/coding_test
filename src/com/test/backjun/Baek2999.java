package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek2999 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String code = reader.readLine();
        int len = code.length();
        int y= 0;
        int x= code.length();
        while(y < x){
            y+=1;
            if(len %y ==0){
                x = len/y;
            }
        }
        int temp =y;
        y=x;
        x= temp;
        char[][] map = new char[y][x];
        int idx =0;
        for (int j = 0; j < x; j++) {
            for (int i = 0; i < y; i++) {
                map[i][j] = code.charAt(idx++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < map.length; i++) {
            sb.append(map[i]);
        }
        System.out.println(sb.toString());
    }
}
