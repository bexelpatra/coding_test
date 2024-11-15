package com.test.HackkerRank.minimumDistances;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'minimumDistances' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY a as parameter.
     */

    public static int minimumDistances(List<Integer> a) {
    // Write your code here
        Map<Integer,List<Integer>> map = new HashMap<>();
        for (int i = 0; i < a.size(); i++) {
            List<Integer> now = map.getOrDefault(a.get(i), new ArrayList<>());
            now.add(i);
            map.put(a.get(i), now);
        }
        int min = 100000000;
        for (Integer key : map.keySet()) {
            List<Integer> now = map.get(key);
            for (int i = 0; i < now.size()-1; i++) {
                int temp = now.get(i+1) - now.get(i);
                min = Math.min(temp,min);
            }
        }
        return min;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int result = Result.minimumDistances(a);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
