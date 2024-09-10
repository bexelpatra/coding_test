package com.test.practice.f_greedy;

// import org.junit.Assert;
// import org.junit.Test;

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
   
}
