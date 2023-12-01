package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek2447 {
    static char[][] map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new char[n][n];
        for (int j = 0; j < n; j++) {
            Arrays.fill(map[j], '*');
        }
        recursive(0, 0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(map[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void recursive(int y, int x ,int len) {
        if(len ==1){
            return;
        }
        int next = len/3;
        for (int i = y+next; i < y+next *2; i++) {
            for (int j = x+next; j < x+next*2; j++) {
                map[i][j] = ' ';
            }
        }
        recursive(y, x, next);
        
        recursive(y, x+next, next);
        recursive(y, x+next*2, next);
        
        recursive(y+next*2, x+next, next);
        recursive(y+next, x+next*2, next);
        
        recursive(y+next, x, next);
        recursive(y+next*2, x, next);
        
        recursive(y+next*2, x+next*2, next);
    }
}
