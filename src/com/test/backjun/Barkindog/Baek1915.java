package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간 초과
public class Baek1915 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

        map = new char[y+1][x+1];
        
        for (int i = 1; i < y+1; i++) {
            String temp = reader.readLine();
            for (int j = 1; j < x+1; j++) {
                map[i][j] = temp.charAt(j-1);
            }
        }
        int idx = 0;
        for (int i = 1; i < y+1; i++) {
            for (int j = 1; j < x+1; j++) {
                while(Check(i, j, idx)){
                    idx+=1;
                }
                // System.out.println(idx);
            }
        }
        System.out.println(idx * idx);
    }
    static char[][] map;
    static int y,x;
    public static boolean Check(int ny, int nx, int len){
        if(map[ny][nx] !='1'){
            return false;
        }
        if(ny+len >=y+1 || nx+len >= x+1){
            return false;
        }
        for (int i = ny; i < ny+len+1; i++) {
            if(map[i][nx]!='1'){
                return false;
            }
        }
        for (int i = nx; i < nx+len+1; i++) {
            if(map[ny][i]!='1'){
                return false;
            }
        }
        
        return true;
    }
}
