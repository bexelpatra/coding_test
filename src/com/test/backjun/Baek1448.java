package com.test.backjun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Baek1448 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // getResult2();
        getResultMy();
        // getResult(n, arr);
    }

    private static void getResultMy() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(reader.readLine());
        }
        Arrays.sort(arr);
        int result = -1;
        // for (int i = 0; i < arr.length-2; i++) {
        //     if(arr[i+2] < arr[i]+arr[i+1]){
        //         result = arr[i] + arr[i+1] + arr[i+2];
        //     }
        // }
        for (int i = arr.length-1; i > 1; i--) {
            if(arr[i] < arr[i-1]+arr[i-2]){
                result = arr[i] + arr[i-1]+arr[i-2];
                break;
            }
        }
        System.out.println(result);
    }

    private static void getResult2() throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] bucket = new int[1_000_001]; // use Count sort
        for (int i = 0; i < n; i++) {
            bucket[Integer.parseInt(br.readLine())]++;
        }

        int ptr = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] <= 0) continue;
            for (int j = 0; j < bucket[i]; j++) {
                arr[ptr] = i;
                ++ptr;
            }
            if(ptr == arr.length){
                break;
            }
        }

        int answer = -1;
        for (int i = n-1; i > 1; i--) {
            if (arr[i] < arr[i-1] + arr[i-2]) {
                answer = arr[i] + arr[i-1] + arr[i-2];
                break;
            }
        }

        bw.write(Integer.toString(answer));
        bw.flush();
    }
    private static void getResult(int n, int[] arr) {
        Arrays.sort(arr);
        int result=-1;
        a :for (int i = n-1; i >=2; i--) {
            for (int j = i-1; j >=1; j--) {
                for (int k = j-1; k >=0; k--) {
                    if(arr[i] < arr[j]+arr[k]){
                        result = arr[i]+arr[j]+arr[k];
                        break a;
                    }
                }
            }
        }
        System.out.println(result);
    }

    
}
