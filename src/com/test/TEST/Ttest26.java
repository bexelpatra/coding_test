package com.test.TEST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gridChallenge' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING_ARRAY grid as parameter.
     */

    public static String gridChallenge(List<String> grid) {
        // Write your code here
            List<char[]> list= new ArrayList<>();
            for (String str : grid) {
                char[] now = str.toCharArray();
                Arrays.sort(now);
                list.add(now);
            }
            int strLen = grid.get(0).length();
            for (int i = 0; i < strLen; i++) {
                char[] now = new char[list.size()];
                for (int j = 0; j < list.size(); j++) {
                    now[j] = list.get(j)[i];
                }
                if(!check(now)){
                    return "NO";
                }
            }
            return "YES";
    }
    public static boolean check(char[] temp){
        for (int i = 0; i < temp.length-1; i++) {
            if(temp[i] > temp[i+1]) return false;
        }
        return true;
    }
}

public class Ttest26 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<String> grid = IntStream.range(0, n).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridChallenge(grid);

                bufferedWriter.write(result);
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}

