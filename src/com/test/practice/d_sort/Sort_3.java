package com.test.practice.d_sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collector;

public class Sort_3 {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int check = 0 ;
        for(int i=0;i<citations.length;i++){
            int h = citations.length-i;
            int citation = citations[i];
            if(h >=citation) {
                answer = citation;
                check++;
            }
        }
        if(check==0) return citations.length;
        return answer;
    }

    public int solution2(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);

        for (int i = 0; i < citations.length; i++) {
            int h = citations.length - i;

            if (citations[i] >= h) {
                answer = h;
                break;
            }
        }

        return answer;
    }
}
