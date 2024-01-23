package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek16113 {
    public static void main(String[] args) throws NumberFormatException, IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            char[] a = reader.readLine().toCharArray();
            int len = a.length;
            char[][] map = new char[len/5][5];
    
            for (int i = 0; i < len/5; i++) {
                for (int j = 0; j < 5; j++) {
                    map[i][j] = a[i+ (j*len/5)];
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < first.length; j++) {
                    if(eq(map[i],first[j])){
                        if(j==0){
                            if(i+1>=map.length){
                                sb.append(1);
                                break;
                            }
                            if(map[i+1][2]=='.'){
                                if(map[i+1][0]=='.'){
                                    sb.append(1);
                                    i-=3;
                                }else{
                                    sb.append(0);
                                }
                            }else{
                                if(map[i+2][1]=='#'){
                                    sb.append(8);
                                }else{
                                    sb.append(6);
                                }
                            }
                        }else if(j==1){
                            sb.append(2);
                        }else if(j==2){
                            sb.append(3);
                        }else if(j==3){
                            sb.append(4);
                        }else if(j==4){
                            if(map[i+2][1]=='#'){
                                sb.append(9);
                            }else{
                                sb.append(5);
                            }
                        }else if(j==5){
                            sb.append(7);   
                        }
                        i+=3;
                        if(i>=map.length){
                            break;
                        }
                        break;
                    }
                }
            }
            System.out.println(sb.toString());
        
       
        
    }
    static boolean eq(char[] a, char[] b){
        for (int i = 0; i < b.length; i++) {
            if(a[i]!=b[i]){
                return false;
            }
        }
        return true;
    }
    static char[][] first = new char[][]{
        {'#','#','#','#','#',} // 0 1 6 8
        ,{'#','.','#','#','#',} // 2
        ,{'#','.','#','.','#',} // 3
        ,{'#','#','#','.','.',} // 4
        ,{'#','#','#','.','#',} // 5 9
        ,{'#','.','.','.','.',} // 7
    };
    
}
