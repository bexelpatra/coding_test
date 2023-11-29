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
        
    }
    public static void recursive(int y, int x,int len){
        
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
