package com.test.HackkerRank.encryption;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

class Result {

    /*
     * Complete the 'encryption' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts STRING s as parameter.
     */

    public static String encryption(String s) {
    // Write your code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char now = s.charAt(i);
            if(now !=' '){
                sb.append(now);
            }
        }
        String temp = sb.toString();
        int len = temp.length();
        int i =1;
        
        int col = 0;
        int row = 0;
        while(i*i <len){
            i+=1;
        }
        
        if(i*i == len){
            col = i;
            row = i;
        }else{
            col = i;
            row = i-1;
        }
        StringBuilder answer = new StringBuilder();
        for (int j = 0; j < col; j++) {
            int idx = j;
            while(idx <temp.length()){
                answer.append(temp.charAt(idx));
                idx+= col;
            }
            answer.append(" ");
        }
        
        return answer.toString();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();

        String result = Result.encryption(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
