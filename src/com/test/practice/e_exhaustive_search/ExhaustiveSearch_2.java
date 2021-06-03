package com.test.practice.e_exhaustive_search;

import java.util.HashSet;
import java.util.Set;

public class ExhaustiveSearch_2 {
    public int solution(String numbers) {
        int answer = 0;
//        int[] number = new int[numbers.length()];
//        int i=0;
//        for(char c : numbers.toCharArray()){
//            number[i++] = Integer.parseInt(String.valueOf(c));
//        };
        Set<String> set = new HashSet<>();
        for(int i=1;i<numbers.length()+1;i++){
            int j = 0;
            while (j<i){
                String.valueOf(numbers.charAt(i));
            }
        }
        return answer;
    }
}
