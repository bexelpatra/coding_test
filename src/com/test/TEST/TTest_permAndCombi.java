package com.test.TEST;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.test.backjun.Barkindog.Baek12100_2;

public class TTest_permAndCombi {
    public static void main(String[] args) throws IOException {
        arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i+1;
        }
        combi(new int[m],new boolean[n], 0,0);
        char[][] a = new char[4][];
        String[] str = {"abc","11adffdad","asdf","가나다라"};
        for (int i = 0; i < a.length; i++) {
            a[i] = str[i].toCharArray();
        }
        for (char[] c : a) {
            System.out.println(c);
        }
    }
    static int n = 4; // n 개중에서
    static int m = 3; // m 개를 뽑는다.
    static int[] arr;
    // idx 는 현재 위치
    public static void combi(int[] result,boolean[] visited, int idx ,int start){ // 조합
        if(idx == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = start; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx] = arr[i];
                combi(result, visited,idx + 1,i +1);
                visited[i] = false;
            }
        }
    }
    public static void perm(int[] result,boolean[] visited, int idx){ // 순열
        if(idx == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx] = arr[i];
                perm(result, visited,idx + 1);
                visited[i] = false;
            }
        }
    }
    public static void all(int[] result, int idx){
        if(idx == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int i = 0; i < n; i++) {
            result[idx] = arr[i];
            all(result,idx + 1);
        }
    }
}
