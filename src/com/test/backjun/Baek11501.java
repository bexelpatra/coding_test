package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek11501 {
    // 이건 안 되는 방법임.
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringTokenizer st =  null;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < loop; i++) {
            int n = Integer.parseInt(reader.readLine());
            int[] arr = new int[n];
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            int result = 0;

            int[] temp = new int[2];
            for (int j = 0; j < arr.length-1; j++) {
                if(arr[j]<=arr[j+1]){
                    temp[0] += 1;
                    temp[1] += arr[j];
                }else{
                    result += arr[j] * temp[0] - temp[1];
                    temp[0] = 0;
                    temp[1] = 0;
                }
            }
            result += (arr[arr.length-1] * temp[0] - temp[1]);
            sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }
}
