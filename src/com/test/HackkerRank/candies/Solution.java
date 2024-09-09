package com.test.HackkerRank.candies;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'candies' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. INTEGER_ARRAY arr
     */

    public static long candies(int n, List<Integer> arr) {
    // Write your code here
        long sum =0;
        int high = 0;
        long[] dp1 = new long[n];
        long[] dp2 = new long[n];
        dp1[0] = 1;
        dp2[n-1] = 1;
        for (int i = 1; i < n; i++) {
            dp1[i] = arr.get(i-1) < arr.get(i) ? dp1[i-1]+1 : 1;
        }
        for (int i = n-2; i >=0; i--) {
            dp2[i] = arr.get(i+1) < arr.get(i) ? dp2[i+1]+1 : 1;
        }
        for (int i = 0; i < n; i++) {
            sum+= Math.max(dp1[i], dp2[i]);
        }
        return sum;
    }

    public static long candies2(int n , List<Integer> arr){
        long sum =0;
        int[] a = new int[n+2];
        for (int i = 0; i < arr.size(); i++) {
            a[i+1] = arr.get(i);
        }
        a[0] = Integer.MAX_VALUE;
        a[n+1] = Integer.MAX_VALUE;

        int[] candies = new int[n+2];
        // valleys
        for (int i = 1; i < n+1; i++) {
            if(a[i-1] >= a[i] && a[i] <= a[i+1]) candies[i] = 1;
        }
        // rises
        for (int i = 1; i < n+1; i++) {
            if(a[i-1] < a[i] && a[i] <= a[i+1]) candies[i] = candies[i-1]+1;
        }
        // falls
        for (int i = n+1; i > 0; i--) {
            if(a[i-1] >= a[i] && a[i] > a[i+1]) candies[i] = candies[i+1] + 1;
        }
        // peaks
        for (int i = 1; i < n+1; i++) {
            if(a[i-1] < a[i] && a[i] > a[i+1]) candies[i] = Math.max(candies[i-1], candies[i+1]) + 1;
        }
        
        for (int i = 1; i < n+1; i++) {
            sum += candies[i];
        }
        return sum;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long result = Result.candies(n, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
