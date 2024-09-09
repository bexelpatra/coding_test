package com.test.HackkerRank.permutationEquation;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;

class Result {

    /*
     * Complete the 'permutationEquation' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY p as parameter.
     */

    public static List<Integer> permutationEquation(List<Integer> p) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        
        int[] layer1 = new int[p.size()+1];
        for (int i = 0; i < p.size(); i++) {
            
            layer1[p.get(i)] = i+1;
        }
        
        // System.out.println(Arrays.toString(layer1));
        for (int i = 0; i <  p.size(); i++) {
            int now = layer1[i+1];
            for (int j = 0; j < p.size(); j++) {
                if(now == p.get(j)){
                    result.add(j+1);
                    break;
                }
            }
        }
        return result;
    }
    public static List<Integer> permutationEquation2(List<Integer> p) {
    // Write your code here
        List<Integer> result = new ArrayList<>();
        
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < p.size(); i++) {
            map.put(p.get(i), i+1 );
        }

        for (int i = 0; i < p.size(); i++) {
            int now = i+1;
            int l1 = map.get(now);
            int l2 = map.get(l1);
            result.add(l2);
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> p = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.permutationEquation2(p);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
