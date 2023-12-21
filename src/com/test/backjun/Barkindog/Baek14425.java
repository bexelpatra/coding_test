package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14425 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String[] set = new String[n];
        for (int i = 0; i < n; i++) {
            set[i] = reader.readLine();
        }
        long sum = 0;
        for (int i = 0; i < m; i++) {
            String find = reader.readLine();
            int[] table = makeTable(find);
            for (String string : set) {
                sum += check(string, find,table);
            }
        }
        System.out.println(sum);
        // System.out.println(sb.toString());
    }
    public static int[] makeTable(String src){
        int len = src.length();
        int[] table = new int[len];
        int idx =0;
        for (int i = 1; i < len; i++) {
            while(idx >0 && src.charAt(i) != src.charAt(idx)){
                idx = table[idx-1];
            }
            if(src.charAt(i)== src.charAt(idx)){
                idx +=1;
                table[i] = idx;
            }
        }
        return table;
    }
    // static StringBuilder sb = new StringBuilder();
    public static int check(String a,String b , int[] table){
        int count = 0;

        int lenA = a.length();
        int lenB = b.length();
        if(lenA != lenB){
            return 0;
        }
        int idx = 0;
        for (int i = 0; i < lenA; i++) {
            while(idx>0 && a.charAt(i)!= b.charAt(idx)){
                idx = table[idx-1];
            }
            if(a.charAt(i)==b.charAt(idx)){
                if(idx == lenB-1){
                    count+=1;
                    idx = table[idx];
                    // sb.append(String.format("%s => %s", a,b)).append("\n");
                }else{
                    idx +=1;
                }
            }
        }
        return count;
    }
}
