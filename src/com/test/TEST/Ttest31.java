package com.test.TEST;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Ttest31 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println(Arrays.toString(list.toArray()));
        BigInteger in= new BigInteger("1", 10);
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        in = in.multiply(new BigInteger("2"));
        System.out.println(in.toString());
    }
    public static int binary(List<Integer> list ,int n){
        int hi = list.size()-1;
        
        return 0;
    }
}
