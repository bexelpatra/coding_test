package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        //TAGC
        int[][] count = new int[m][4] ;
        for (int i = 0; i < n; i++) {
            String temp = reader.readLine();
            for (int j = 0; j < m; j++) {
                count[j][con(temp.charAt(j))] +=1;
            }
        }
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        for (int i = 0; i < count.length; i++) {
            int max = 0;
            char c = ' ';
            for (int j = 0; j < count[i].length; j++) {
                if(max < count[i][j]){
                    max = count[i][j];
                    c = con(j);
                }
            }
            sb.append(c);
            ans += (n-max);
        }
        
        System.out.println(sb.toString());
        System.out.println(ans);
    }
    static int con(char c){
        int result = -1;
        switch (c) {
            case 'A':
                result=0;
                break;
            case 'C':
                result=1;
                break;
            case 'G':
                result=2;
                break;
            case 'T':
                result=3;
                break;
        
            default:
                break;
        }
        return result;
    }
    static char con(int c){
        char result = ' ';
        switch (c) {
            case 0:
                result='A';
                break;
            case 1:
                result='C';
                break;
            case 2:
                result='G';
                break;
            case 3:
                result='T';
                break;
        
            default:
                break;
        }
        return result;
    }
}
