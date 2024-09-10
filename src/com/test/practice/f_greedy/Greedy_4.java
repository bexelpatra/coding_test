package com.test.practice.f_greedy;

// import org.junit.Assert;
// import org.junit.Test;

import java.util.Arrays;

public class Greedy_4 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int max = people.length;
        int pointer = 1;
        for(int i=max-1;i<max;i++){
            if(people[i]+ people[people.length-pointer]<=limit){
                max-=1;
                pointer+=1;
            }
            answer+=1;
        }
        return answer;
    }
    public int solution2(int[] people, int limit) {
        int answer = 0;

        Arrays.sort(people);

        int min = 0;

        for (int max = people.length - 1; min <= max; max--){
            if (people[min] + people[max] <= limit) min++;
            answer++;
        }

        return answer;
    }
    
}
