package com.test.TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TTest32 {
    public static void main(String[] args) {
        // int a = 13;
        // int b = 2;
        // System.out.println(a&b);
        // System.out.println(a^b);
        // System.out.println(a|b);
        // System.out.println(Integer.toBinaryString(a | b));

        // String temp ="1101";

        List<Integer> list = new ArrayList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.parallelStream()
        .filter((integer) -> {
            return integer>3;
        })
        .forEach(System.out::println);
        char[] temp = new char[3];
        System.out.println(Arrays.toString(temp));
        System.out.println(temp[0]==0);

        String aa = "123";
        System.out.println(findDigit(99999));
        
        kaprekarNumbers(1, 99999);
    }
    public static void kaprekarNumbers(int p, int q) {
        // Write your code here
            StringBuilder sb = new StringBuilder();
            for (int i = p; i <= q; i++) {
                if(i== 99999){
                    System.out.println("");
                }
                int digit = findDigit(i)*10;
                long sq = (long)i * (long)i;
                long sum = sq /digit + sq % digit;
                if(sum == i){
                    sb.append(i).append(" ");
                }
            }
            if(sb.length() ==0){
                System.out.println("INVALID RANGE");
            }else{            
                System.out.println(sb.toString());
            }
        }
    public static int findDigit(int n){
        int i =100000;
        while(n/i ==0){
            i /= 10;
        }
        return i;
    }
}
