package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1759 {
    static String[] temp;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        temp = reader.readLine().split(" ");
        Arrays.sort(temp);
        cipher(new char[n], new boolean[m], 0, 0);
        System.out.println(sb.toString());
    }
    static StringBuilder sb = new StringBuilder();
    public static void cipher(char[] result, boolean[] visited, int idx, int start){
        if(idx == result.length){
            int count = count(result);
            if(count>0 && result.length-count >1){
                sb.append(result).append("\n");
            }
            return;
        }

        for (int i = start; i < temp.length; i++) {
            if(!visited[i]){
                visited[i] = true;
                result[idx] = temp[i].charAt(0);

                cipher(result,visited,idx+1,i+1);
                
                visited[i] = false;
            }
        }
    }
    static char[] vowl ={'a','e','i','o','u'};
    public static int count(char[] a){
        int result = 0;
        for (char c : a) {
            for (char d : vowl) {
                if(c-d==0){
                    result+=1;
                }
            }
        }
        return result;
    }
}
