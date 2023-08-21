package com.test.backjun;

public class Baek15549 {
    public static void main(String[] args) {
        // int x = -2147483648;
        long x = Long.MIN_VALUE;
        System.out.println(x);
        System.out.println(-x);
        ;
        if (x != 0 && x == -x) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
