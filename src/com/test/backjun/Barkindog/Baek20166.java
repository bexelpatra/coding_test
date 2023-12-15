package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Baek20166 {
    static Map<String,Integer> count = new HashMap<>();
    static int y,x,n;
    static char[][] map;
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
        String[] arr = new String[n];
        for (int i = 0; i < arr.length; i++) {
            // arr[i] = reader.readLine();
            count.put(reader.readLine(), 0);
        }
        
        for (int i = 1; i < y+1; i++) {
            for (int j = 1; j < x+1; j++) {
                recursive(i, j, 0, new char[n]);
            }
        }

        StringBuilder sb = new StringBuilder();
        // count.forEach((t, u) ->sb.append(t).append(" : ").append(u).append("\n") );
        for (String string : arr) {
            sb.append(count.getOrDefault(string, 0)).append("\n");
        }
        System.out.println(sb.toString());

    }
    static int[] nextY1 ={0,0,1,-1};
    static int[] nextx1 ={1,-1,0,0};
    
    static int[] nextY2 ={1,1,-1,-1};
    static int[] nextx2 ={1,-1,1,-1};
    // static int[][] list = new int[2][2];
    public static void recursive(int ny, int nx,int len,char[] result){
        result[len] = map[ny][nx];
        // list[len] = new int[]{ny,nx};
        if(len == n-1){
            String key = new String(result);
            int num  = count.getOrDefault(key,0);
            if(num !=0){
                count.put(key, num+1);
            }
            // for (int[] c : list) {
            //     System.out.println(Arrays.toString(c));
            // }
            // System.out.println();
            return;
        }

        int goY = 0;
        int goX = 0;
        for (int i = 0; i < 4; i++) {
            goY = ny + nextY1[i];
            goX = nx + nextx1[i];
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
            recursive(goY, goX, len+1, result);
        }

        for (int i = 0; i < 4; i++) {
            goY = ny + nextY2[i];
            goX = nx + nextx2[i];
            if(goY <1){
                goY = y;
            }
            if(goX<1){
                goX = x;
            }
            if(goY>y){
                goY = 1;
            }
            if(goX>x){
                goX = 1;
            }
            recursive(goY, goX, len+1, result);
        }
    }
    
}
