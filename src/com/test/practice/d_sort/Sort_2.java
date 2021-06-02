package com.test.practice.d_sort;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

public class Sort_2 {
    public String solution(int[] numbers) {
        String answer = "";
        StringBuilder builder = new StringBuilder();
        Iterator<Integer> integers = Arrays.stream(numbers).boxed().sorted((o1, o2) -> {
            String a= String.valueOf(o1);
            String b= String.valueOf(o2);
            for(int i=0;i<3;i++){
                a+=a;
                b+=b;
            }
            return b.compareTo(a);
        }).iterator();

        while(integers.hasNext()){
            int num = integers.next();
            builder.append(num);
        }
        answer = builder.toString();
        if(answer.startsWith("0")) return "0";
        return answer;
    }
}
