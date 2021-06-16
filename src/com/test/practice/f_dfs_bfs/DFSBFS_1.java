package com.test.practice.f_dfs_bfs;

import java.util.Arrays;

public class DFSBFS_1 {
    int count = 0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = count;
        recursive(numbers,-1,target);
        System.out.println(count);
        return answer;
    }

    private void recursive(int[] numbers, int index, int target){
        if(index == numbers.length-1){
            int sum=Arrays.stream(numbers).sum();
            if(sum == target) count++;
            return;
        }
        index+=1;
        int x = index;
        recursive(numbers,x,target);

        numbers[x] = -numbers[x];
        recursive(numbers,x,target);
    }
}
