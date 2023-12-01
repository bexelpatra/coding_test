package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek1992 {
    static char[][]map;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new char[n][];
        for (int i = 0; i < n; i++) {
            map[i] = reader.readLine().toCharArray();
        }
        recursive(0, 0, n, 0);
        System.out.println(sb.toString());
    }
    static StringBuilder sb = new StringBuilder();
    public static void recursive(int y, int x,int len,int po){
        if(check(y, x, len)){
            //  po위치에 따라서 값이 달라진다..? 
            char now = map[y][x];
            sb.append(now);
            return;
        }
        int next = len/2;
        sb.append("(");
        recursive(y, x, next, 0);  // 좌상
        
        recursive(y, x+next, next, 1); // 우상
        
        recursive(y+next, x, next, 2); // 좌하
        
        recursive(y+next, x+next, next, 3); // 우하
        sb.append(")");
    }

    public static boolean check(int y, int x, int len){
        char a = map[y][x];
        for (int i = y; i < y+len; i++) {
            for (int j = x; j < x+len; j++) {
                if(a != map[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
