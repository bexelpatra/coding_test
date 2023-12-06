package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
    실패 기록
    
    try 1
    1. 움직이고 마지막 자리에서 검사하지 않아서 -1을 남김
    2. 움직이려는 줄과 방향에 따라서 trim 처리하면서 진행해볼 예정


 */
public class Baek12100 {
    static int map[][];
    static int origin[][];
    static long max = -1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader= new BufferedReader(new InputStreamReader(System.in));
        os = new FileOutputStream(new File("d://result.txt"));
        int n = Integer.parseInt(reader.readLine());

        origin = new int[n][n];
        map = new int[n][n];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                origin[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, origin[i][j]);
            }
        }
        copyOrigin();
        // recur(new int[5], 0);

        int[] arrr = {3, 3, 2, 3, 0};
        for (int i : arrr) {
            move(i);
            print(map);
        }
        
        System.out.println(max);
        os.flush();
        os.close();
        reader.close();
        
    }
    static FileOutputStream os;
    static int[] directions={0,1,2,3};
    public static void print(int[][] arrr){
        for (int[] is : arrr) {
            System.out.println(Arrays.toString(is));
            try {
                os.write(Arrays.toString(is).getBytes());
                os.write("\n".getBytes());
                
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            os.write("\n".getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println();
    }
    public static void recur(int[] order,int idx){
        if(idx == directions.length){
            for (int i : order) {
                move(i);
            }
            System.out.println(Arrays.toString(order));
            print(map);
            copyOrigin();
            
            return;
        }
        for (int i = 0; i < directions.length; i++) {
            order[idx] = directions[i];
            recur(order, idx+1);
        }
    }
    public static void copyOrigin(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                map[i][j] = origin[i][j];
            }
        }
    }
    public static void trim(int a){
        int count = 0;
        int len = map.length;
        int[] arr = new int[len];
        if(a==0){ // 오른쪽
            for (int y = 0; y < len; y++) {
                count = len-1;
                for (int x = len-1; x >=0; x--) {
                    if(map[y][x]!=0){
                        arr[count--] = map[y][x];
                    }
                }
                map[y]=arr;
                arr = new int[len];
            }
        }else if(a==1){ // 아래쪽
            for (int x = 0; x < len; x++) {
                count = len-1;
                for (int y = len-1; y >=0; y--) {
                    if(map[y][x] !=0){
                        arr[count--] = map[y][x];
                    }
                }
                for (int i = len-1; i >= 0; i--) {
                    map[i][x] = arr[i];
                }
                arr = new int[len];
            }
        }else if(a==2){ //왼쪽
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len; x++) {
                    if(map[y][x] !=0){
                        arr[count++]=map[y][x];
                    }
                }
                count=0;
                map[y]=arr;
                arr = new int[len];
            }
        }else if(a==3){ // 위쪽
            for (int x = 0; x < len; x++) {
                for (int y = 0; y < len; y++) {
                    if(map[y][x] !=0){
                        arr[count++] = map[y][x];
                    }
                }
                for (int i = 0; i < len; i++) {
                    map[i][x] = arr[i];
                }
                count=0;
                arr = new int[len];
            }
            
        }
    }
    public static void move(int a){
        trim(a);
        int len = map.length;
        if(a==0){ // 오른쪽
            for (int y = 0; y < len; y++) { // y
                for (int x = len-2; x >=0; x--) {
                    if(map[y][x+1]==-1){
                        map[y][x+1] = map[y][x];
                        map[y][x]=0;
                    }
                    if(map[y][x] ==map[y][x+1] && map[y][x] !=0){
                        map[y][x+1] *=2;
                        map[y][x] = -1;
                        max = Math.max(max, map[y][x+1]);
                    }
                }
                if(map[y][0]==-1){
                    map[y][0]=0;
                }
            }
        }else if(a==1){//아래쪽
            for (int x = 0; x < len; x++) { // y
                for (int y = len-2; y >=0; y--) {
                    if(map[y+1][x]==-1){
                        map[y+1][x] = map[y][x];
                        map[y][x]=0;
                    }
                    if(map[y][x] ==map[y+1][x] && map[y][x] !=0){
                        map[y+1][x] *=2;
                        map[y][x] = -1;
                        max = Math.max(max, map[y+1][x]);
                    } 
                }
                if(map[0][x]==-1){
                    map[0][x]=0;
                }
            }
        }else if(a==2){// 왼쪽
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len-1; x++) {
                    if( map[y][x]==-1){
                        map[y][x]=map[y][x+1];
                        map[y][x+1] =0;
                    }
                    if(map[y][x] == map[y][x+1] && map[y][x] !=0){
                        map[y][x]*=2;
                        map[y][x+1] = -1;
                        max = Math.max(max, map[y][x]);
                    }
                }
                if(map[y][len-1]==-1){
                    map[y][len-1]=0;
                }
            }
        }else if(a==3){//위쪽
            for (int x = 0; x < len; x++) {
                for (int y = 0; y < len-1; y++) {
                    if( map[y][x]==-1){
                       map[y][x]=map[y+1][x];
                       map[y+1][x] =0;
                    }
                    if(map[y+1][x] == map[y][x] && map[y][x] !=0){
                        map[y][x]*=2;
                        map[y+1][x] = -1;
                        max = Math.max(max, map[y][x]);
                    }
                }
                if(map[len-1][x]==-1){
                    map[len-1][x] = 0;
                }
            }
        }

    }
}
