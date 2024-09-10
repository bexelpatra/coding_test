package com.test.practice.g_dynamic_programming;

// import org.junit.Assert;
// import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DynamicProgramming_4 {

    // 오답노트 ?
    // 동적프로그래밍답게 효율적으로 짜야 한다.
    // 재귀를 통한 반복은 비효율적.
    public int solution(int[] money) {
        int answer = 0;
        Set<Integer> integerList = new HashSet<>();

        recursive(Arrays.stream(money,0,money.length-1).toArray(),0,0,integerList);
        recursive(money,1,0,integerList);
        return integerList.stream().max(Integer::compareTo).get();
    }
    public void recursive(int[] money, int index,int sum,Set<Integer> list){
        if(money.length -1< index){
            list.add(sum);
            return;
        }
        sum += money[index];
        recursive(money, index+2, sum, list);
        recursive(money, index+3, sum, list);
    }
    public int solution2(int[] money) {
        int answer = 0;
        int length = money.length;
        int[] dp =new int[length-1];
        int[] dp2= new int[length];

        dp[0]=money[0];
        dp[1]=money[0];
        dp2[0]=0;
        dp2[1]=money[1];
        for(int i=2;i<length-1;i++){
            int a = dp[i-2]+money[i];
            int b = dp[i-1];
            dp[i]=Math.max(dp[i-2]+money[i],dp[i-1]);
        }
        for(int i=2;i<length;i++){
            int a = dp2[i-2]+money[i];
            int b = dp2[i-1];
            dp2[i]=Math.max(dp2[i-2]+money[i],dp2[i-1]);
        }

        return Math.max(dp[length-2],dp2[length-1]);
    }
  
}

