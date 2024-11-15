package com.test.HackkerRank.gridSearch;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;

class Result {

    /*
     * Complete the 'gridSearch' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING_ARRAY G
     *  2. STRING_ARRAY P
     */

    public static String gridSearch(List<String> G, List<String> P) {
    // Write your code here
        int gyLen = G.size();
        int pyLen = P.size();

        int gxLen = G.get(0).length();
        int pxLen = P.get(0).length();

        int y = 1;
        for (int i = 0; i < gyLen-pyLen+1; i++) {
            String now = G.get(i);
            for (int j = 0; j < now.length()-pxLen+1; j++) {
                int count = check(now,j, P.get(0));
                if(count == P.get(0).length()){
                    while(y < P.size()){
                        if(check(G.get(i+y), j, P.get(y))==P.get(y).length()){
                            y+=1;
                        }else{
                            break;
                        }
                    }
                    if(y == P.size()){
                        return "YES";
                    }
                    y=1;
                }
            }
        }
        return "NO";
    }
    public static int check(String a,int start, String b){
        int count = 0 ;
        for (int i = 0; i < b.length(); i++) {
            if(a.charAt(i+start)==b.charAt(i)){
                count+=1;
            }else{
                return 0;
            }
        }
        return count;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int R = Integer.parseInt(firstMultipleInput[0]);

                int C = Integer.parseInt(firstMultipleInput[1]);

                List<String> G = IntStream.range(0, R).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String[] secondMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int r = Integer.parseInt(secondMultipleInput[0]);

                int c = Integer.parseInt(secondMultipleInput[1]);

                List<String> P = IntStream.range(0, r).mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                    .collect(toList());

                String result = Result.gridSearch(G, P);

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
