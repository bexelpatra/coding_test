package com.test.TEST;

import java.util.Arrays;
import java.util.stream.IntStream;

public class BinarySearchTest {
    public static void main(String[] args) {
        int[] arr= IntStream.generate(() -> {return (int)(Math.random()*100)+1;}).limit(15).sorted().toArray();
        
        System.out.println(Arrays.toString(arr));
    }

    public static int lowwer(int[] arr, int key){
        int lo = 0;
        int hi= arr.length;
        while(lo<hi){
            int mid = ((hi + lo)/2);
        }

    }
}
