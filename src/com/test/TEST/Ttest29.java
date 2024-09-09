package com.test.TEST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Ttest29 {
    class Result {
    
        /*
         * Complete the 'getTotalX' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY a
         *  2. INTEGER_ARRAY b
         */
        
        public static int getTotalX(List<Integer> a, List<Integer> b) {
        // Write your code here
            int lcm=a.get(0);
            int gcd=b.get(0);
            for (int i = 0; i < b.size(); i++) {
                gcd = gcd(gcd, b.get(i));
            }
            for (int i = 0; i < a.size(); i++) {
                lcm = lcm(lcm, a.get(i));
            }
            int count =0;
            System.out.printf("lcm : %d gcd : %d \n",lcm,gcd);
            for (int i = lcm; i <= gcd; i++) {
                if(gcd % i ==0 && i % lcm ==0 && i!=0){
                    count+=1;
                    System.out.println(i);
                }
            }
            return count;
            
        }
        public static int gcd(int a, int b){
            if(b>a){
                int temp = b;
                b = a;
                a =temp;
            }
            while(b!=0){
                int temp = a%b;
                a = b;
                b = temp;
            }
            return a;
        }
        
        public static int lcm(int a, int b){
            return a*b / gcd(a, b);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> brr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        int total = Result.getTotalX(arr, brr);

        bufferedWriter.write(String.valueOf(total));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
