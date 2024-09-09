package com.test.TEST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Ttest28 {
    class Result {
    
        /*
         * Complete the 'timeConversion' function below.
         *
         * The function is expected to return a STRING.
         * The function accepts STRING s as parameter.
         */
    
        public static String timeConversion(String s) {
        // Write your code here
            char AP = s.charAt(8);
            String[] hms = s.substring(0, 8).split(":");
            StringBuilder sb = new StringBuilder();
            if(AP=='A'){
                int i =0;
                if(hms[0].equals("12")){
                    sb.append("00").append(":");
                    i=1;
                }
                for (;i < 3; i++) {
                    sb.append(hms[i]).append(":");
                }
                sb.deleteCharAt(sb.length());
            }else{
                
                int h = Integer.parseInt(hms[0]);
                if(h!=12){
                    h+=12;
                    sb.append(h).append(":");
                }else{
                    sb.append(hms[0]).append(":");
                }
                sb.append(hms[1]).append(":").append(hms[2]);
            }
    
            return sb.toString();
        }
    
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = bufferedReader.readLine();
        String result = Result.timeConversion(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
