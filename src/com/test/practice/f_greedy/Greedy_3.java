package com.test.practice.f_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Greedy_3 {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        int skip = 0;
        int time = number.length()-k;
        int rest = k+1;

        char max = 0;

        for(int i=0;i<time;i++){
            for(int j=skip;j<rest;j++){
                if(max < number.charAt(j)){
                    max = number.charAt(j);
                    skip = j+1;
                }
            }
            rest+=1;
            builder.append(max);
            max=0;
        }
        return builder.toString();
    }
    @Test
    public void test(){
        Assert.assertEquals("94",solution("1924",2));
        Assert.assertEquals("3234",solution("1231234",3));
        Assert.assertEquals("775841",solution("4177252841",4));

    }
}
