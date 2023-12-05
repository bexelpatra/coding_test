package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek12100 {
    static int map[][];
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
    public static void move(int a){
        int len = map.length;
        if(a==0){ // 오른쪽
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len-1; j++) {
                    if(map[i][j] ==map[i][j-1]){
                        
                    }
                }
            }
        }else if(a==1){//아래쪽

        }else if(a==2){// 왼쪽
            
        }else if(a==3){//위쪽
            
        }
    }
}
