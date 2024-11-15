package com.test.HackkerRank.beautifulTriplets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'beautifulTriplets' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER d
     *  2. INTEGER_ARRAY arr
     */

    public static int beautifulTriplets(int d, List<Integer> arr) {
    // Write your code here
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            int num = arr.get(i);
            Integer now = map.get(num);
            if(now == null){
                map.put(num,1);
            }else{
                map.put(num, now+1);
            }
        }
        int count =0;
        int last = -1;
        for (int i = 0; i < arr.size(); i++) {
            int now = arr.get(i);
            if(last == now){
                continue;
            }
            last = now;
            int temp =1;
            for (int j = 0; j < 3; j++) {

                Integer num = map.get(j*d + now);
                if(num ==null) {
                    num = 0;
                }
                temp*=num;
            }
            count+=temp;
        }
        return count;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.beautifulTriplets(d, arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
