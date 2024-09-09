package com.test.TEST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;


public class Ttest30 {
    class Result {
    
        /*
         * Complete the 'pickingNumbers' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts INTEGER_ARRAY a as parameter.
         */
    
        public static int pickingNumbers(List<Integer> a) {
        // Write your code here
            int size = a.size();
            int[] dp = new int[size];
            for (int i = 0; i < size; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    int now = Math.abs(a.get(i)-a.get(j));
                    if(dp[i]  < dp[j]+1 && now<=1 ){
                        dp[i] +=1;
                    }
                }
            }
            int max = 0;
            for(int i =0 ; i < size ;i++){
                max = Math.max(max,dp[i]);
            }
            ;
            System.out.println(Arrays.toString(dp));
            return max;
            
        }
        public static int pickingNumbers2(List<Integer> a) {
            // Write your code here
            int[] arr = new int[100];
            int max = 0;
            
            for(int i=0; i<a.size(); i++) {
                arr[a.get(i)]++;
            }
            
            for(int i=0; i<arr.length-1; i++) {
                if(arr[i] + arr[i+1] > max) {
                    max = arr[i] + arr[i+1];
                }
            }
            
            return max;
    
        }
    }
    public static void main(String[] args) throws IOException {
        // String[] temp = "84 43 11 41 2 99 31 32 56 53 42 14 98 27 64 57 16 33 48 21 46 61 87 90 28 12 62 49 29 77 82 70 80 89 95 52 13 19 9 79 35 67 51 39 7 1 66 8 17 85 71 97 34 73 75 6 91 40 96 65 37 74 20 68 23 47 76 55 24 3 30 22 55 5 69 86 54 50 10 59 15 4 36 38 83 60 72 63 78 58 88 93 45 18 94 44 92 81 25 26".split(" ");
        // int[] arr = new int[temp.length];
        // for (int i = 0; i < temp.length; i++) {
        //     arr[i] = Integer.parseInt(temp[i]);
        // }
        // Arrays.sort(arr);
        // System.out.println(Arrays.toString(arr));
        System.out.println(new Date().getTime());
        if(11!=1){
            return;
        }
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.pickingNumbers(a);
        int result2 = Result.pickingNumbers2(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.write("\n");
        bufferedWriter.write(String.valueOf(result2));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
