package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1932 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] triangle = new int[n+1][];
        StringTokenizer st = null;
        for (int i = 1; i < triangle.length; i++) {
            st = new StringTokenizer(reader.readLine());
            int[] temp = new int[i];
            for (int j = 0; j < temp.length; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }
            triangle[i] = temp;
        }
        for (int i = 2; i < triangle.length; i++) {
            int len = triangle[i].length;
            triangle[i][0] += triangle[i-1][0];
            triangle[i][len-1] += triangle[i-1][len-2];
            for (int j = 1; j < len-1; j++) {
                triangle[i][j] += Math.max(triangle[i-1][j],triangle[i-1][j-1]) ;
            }
        }
        // for (int[] is : triangle) {
        //     System.out.println(Arrays.toString(is));
        // }
        int max = 0;
        for (int i = 0; i < triangle[n].length; i++) {
            max = Math.max(max, triangle[n][i]);
        }

        System.out.println(max);

    }    
}
