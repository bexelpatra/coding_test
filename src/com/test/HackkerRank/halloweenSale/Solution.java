package com.test.HackkerRank.halloweenSale;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'howManyGames' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER p start
     *  2. INTEGER d space
     *  3. INTEGER m min
     *  4. INTEGER s budget
     */

    public static int howManyGames(int p, int d, int m, int s) {
    // Return the number of games you can buy
        int count = 0;
        while(s>0){
            if(s-p>=0){
                System.out.printf("%d %d\n",s , p);
                count +=1;
                s -=p;
                p-=d;
                if(p < m){
                    p = m;
                }
            }else{
                break;
            }
        }
        
        return count;
        
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int p = Integer.parseInt(firstMultipleInput[0]);

        int d = Integer.parseInt(firstMultipleInput[1]);

        int m = Integer.parseInt(firstMultipleInput[2]);

        int s = Integer.parseInt(firstMultipleInput[3]);

        int answer = Result.howManyGames(p, d, m, s);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
