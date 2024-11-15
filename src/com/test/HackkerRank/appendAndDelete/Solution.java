package com.test.HackkerRank.appendAndDelete;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'appendAndDelete' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. STRING t
     *  3. INTEGER k
     */

    public static String appendAndDelete(String s, String t, int k) {
    // Write your code here

        int shortLen = s.length() - t.length() >0 ? t.length() : s.length();
        int n = 0;
        for (int i = 0; i < shortLen; i++) {
            if(s.charAt(i) != t.charAt(i)){
                n= i + 1;
                break;
            }
        }
        if(n==0){
            n=shortLen;
        }
        int minus = s.length() - n+1;
        int plus = t.length() - n+1;
        
        while(minus + plus < k){
            if(minus < s.length()){
                minus+=1;
                plus +=1;
            }else{
                plus+=1;
            }
        }
        if(minus+plus == k){
            return "Yes";
        }
        return "No";
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String t = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.appendAndDelete(s, t, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
