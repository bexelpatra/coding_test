package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek20166 {
    static Map<String,Integer> count = new HashMap<>();
    static int y,x,n;
    static char[][] map;
    static String[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new char[y+1][x+1];
        String temp = "";
        for (int i = 1; i < y+1; i++) {
            temp = reader.readLine();
            for (int j = 1; j < x+1; j++) {
                map[i][j] = temp.charAt(j-1);
            }
        }
        arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = reader.readLine();
            count.put(arr[i], 0);
        }
        
        for (int k = 0; k < arr.length; k++) {
            if(count.get(arr[k])==0){
                for (int i = 1; i < y+1; i++) {
                    for (int j = 1; j < x+1; j++) {
                        if(arr[k].charAt(0)== map[i][j]){
                            recursive(i, j, 0,k);
                        }
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String string : arr) {
            sb.append(count.getOrDefault(string, 0)).append("\n");
        }
        System.out.println(sb.toString());

    }
    static int[] nextY ={0,0,1,-1,1,1,-1,-1};
    static int[] nextX ={1,-1,0,0,1,-1,1,-1};
    
    public static void recursive(int ny, int nx,int len,int k){
        if(map[ny][nx] != arr[k].charAt(len)){
            return;
        }
        if(len+1 == arr[k].length()){
            Integer num  = count.get(arr[k]);
            if(num !=null){
                count.put(arr[k], num+1);
            }
            return;
        }

        int goY = 0;
        int goX = 0;
        for (int i = 0; i < 8; i++) {
            goY = ny + nextY[i];
            goX = nx + nextX[i];
            if(goY <1){
                goY = y;
            }
            if(goX<1){
                goX = x;
            }
            if(goY>y){
                goY=1;
            }
            if(goX>x){
                goX = 1;
            }
            recursive(goY, goX, len+1,k);
        }

    }
    
}
