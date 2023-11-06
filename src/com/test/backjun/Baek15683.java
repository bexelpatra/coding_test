package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Baek15683 {
    static int[][] map;
    static List<Node> walls;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int y= Integer.parseInt(st.nextToken());
        int x= Integer.parseInt(st.nextToken());
        map = new int[y+1][x+1];
        walls = new ArrayList<>();
        List<Node> list = new ArrayList<>();
        for (int i = 1; i <= y; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= x; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 6){
                    walls.add(new Node(j, i,map[i][j]));
                }else if(map[i][j]!=0){
                    list.add(new Node(j, i,map[i][j]));
                }
            }
        }

        int loop = (int)(Math.pow(4, list.size()));
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            int temp = Integer.parseInt(Integer.toString(i,4)) ;
            int idx = 0;
            boolean[][] visited;
            // sb.append(String.format("%08d",temp)).append("\n");
            while(temp > 0){
                Node now = list.get(idx++);
                now.setDirection(temp % 4);
                temp /=10;
            }
            visited= new boolean[y+1][x+1];
            for (Node wall : walls) {
                visited[wall.y][wall.x] = true;
            }
            for (Node n : list) {
                check(visited, n);
            }
            // for (boolean[] bool : visited) {
            //     System.out.println(Arrays.toString(bool));
            // }
            // System.out.println();
            // System.out.println(count(visited));
            min = Math.min(count(visited), min);
        }
        // System.out.println(sb.toString());
        System.out.println(min);
    }

    public static void check(boolean[][] visited,Node node){
        int[] arr = null;
        switch (node.cctv) {
            case 1:
                arr = new int[1];
                arr[0] = node.direction;
                break;
            case 2:
                arr = new int[2];
                arr[0] = node.direction;                
                arr[1] = (node.direction+2)%4;     
                break;
            case 3:
                arr = new int[2];
                arr[0] = node.direction;                
                arr[1] = (node.direction+1)%4;                     
                break;
            case 4:
                arr = new int[3];
                arr[0] = node.direction;                
                arr[1] = (node.direction+1)%4;  
                arr[2] = (node.direction+2)%4;  
                break;
            case 5:
                arr = new int[4];
                arr[0] = 0;
                arr[1] = 1;
                arr[2] = 2;
                arr[3] = 3;
                break;
        
            default:
                break;
        }
        
        for (int dir : arr) {
            switch (dir) {
                case 0: // 우측 (x ++)
                    for (int i = node.x; i < visited[0].length; i++) {
                        visited[node.y][i] = true;
                        if(map[node.y][i]== 6){
                            break;
                        }
                    }
                    break;
                case 1: // 아래(y --)
                    for (int i = node.y; i >= 0; i--) {
                        visited[i][node.x] = true;
                        if(map[i][node.x]== 6){
                            break;
                        }
                    }
                    break;
                case 2:// 좌측(x --)
                    for (int i = node.x; i >=0; i--) {
                        visited[node.y][i] = true;
                        if(map[node.y][i]== 6){
                            break;
                        }
                    }
                    break;
                case 3:// 위(y ++)
                    for (int i = node.y; i < visited.length; i++) {
                        visited[i][node.x] = true;
                        if(map[i][node.x]== 6){
                            break;
                        }
                    }
                    break;
                default:
                    break;
            }
        }
        
        
    }
    public static int count(boolean[][] visited){
        int count = 0;
        for (int i = 1; i < visited.length; i++) {
            for (int j = 1; j < visited[i].length; j++) {
                if(!visited[i][j]){
                    count+=1;
                }
            }
        }
        return count;
    }
    static class Node{
        public int x;
        public int y;
        public int direction;
        public int cctv;
        public Node(int x , int y,int cctv){
            this.x = x;
            this.y = y;
            this.cctv = cctv;
        }
        public void setDirection(int d){
            if(cctv == 2){
                direction = d%2;
            }else if(cctv == 5){
                // 아무것도 안함
                direction=0;
            }else {
                direction = d;
            }
        }
    }
}
