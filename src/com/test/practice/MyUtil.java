package com.test.practice;

import java.util.ArrayList;
import java.util.List;

public class MyUtil {
    public static<T> void printArray(List<T> list){
        list.stream().forEach(o -> System.out.print(o + ","));
    }
    public static int[] array(String x){
        x = x.replace("[","").replace("]","");

        String[] strings = x.split(",");
        int[] ints = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
            String num = strings[i].trim();
            boolean negative = false;
            if(num.startsWith("-")){
                negative = true;
                num = num.substring(1);
            }
            ints[i] = Integer.parseInt(num);
            if(negative){
                ints[i] = -ints[i];
            }
        }
        return ints;
    }

    public static int[][] squareArray(String x){
        x = x.substring(1,x.length()-1);
        x = x.replace("],","]@");
        String[] strings = x.split("@");
        int[][] ints = new int[strings.length][];
        for (int i = 0; i < strings.length; i++) {
            ints[i] = array(strings[i]);
        }
        return ints;
    }
}
