package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek1041 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long n = Integer.parseInt(reader.readLine());
        int[] dice = new int[6];
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int one = Integer.MAX_VALUE;
        for (int i = 0; i < dice.length; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
            one = one -dice[i] >0 ? dice[i] : one;
        }
//        long sum =0;
        BigInteger sum = new BigInteger("0");
        if (n==1){
            Arrays.sort(dice);
            for (int i = 0; i < dice.length-1; i++) {
                sum = sum.add(new BigInteger(dice[i]+""));
//                sum+=dice[i];
            }
        }else if (n==2){
            System.out.println(4*three(dice)+4*two(dice));
            return;
        }else{
            BigInteger bi = new BigInteger(n+"");
            bi = bi.multiply(bi);
            bi = bi.multiply(new BigInteger("5"));

            long threeSide = 4;
            long twoSide = 4*(2*n-3);
            long temp = (threeSide*3 + twoSide*2); // 면의 개수
            bi = bi.subtract(new BigInteger(String.valueOf(temp)));

            long threeTwo = threeSide*three(dice) + twoSide*two(dice);
            sum = sum.add(new BigInteger(String.valueOf(threeTwo)));
            // 4귀퉁이 높이  (n-1)*4
            // 가장 윗면 (n-2)*4
            sum = sum.add(new BigInteger(String.valueOf(one)).multiply(new BigInteger(String.valueOf(bi))));
        }
        System.out.println(sum.toString());
        return;
    }
    public static long three(int[] dice){
        int[] a = new int[]{0,5};
        int[] b = new int[]{1,4};
        int[] c = new int[]{2,3};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                for (int k = 0; k < c.length; k++) {
                    min = Math.min(min,(dice[a[i]]+dice[b[j]]+dice[c[k]]));
                }
            }
        }
        return min;
    }
    public static long two(int[] dice){
        int[] a = new int[]{0,5};
        int[] b = new int[]{1,4};
        int[] c = new int[]{2,3};
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                min = Math.min(min,dice[a[i]]+dice[b[j]]);
            }
        }
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < c.length; j++) {
                min = Math.min(min,dice[a[i]]+dice[c[j]]);
            }
        }
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < b.length; j++) {
                min = Math.min(min,dice[c[i]]+dice[b[j]]);
            }
        }
        return min;
    }
}


/*
3 by 3
* 45 면
  3면 : 4개 -> 12
* 2면 : (3-2)*4 + (3-1)*4 -> 24
* 1면 : 9
* */