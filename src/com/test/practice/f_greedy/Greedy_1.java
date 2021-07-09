package com.test.practice.f_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class Greedy_1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] students = new int[n];
        for(int i=0;i<lost.length;i++){
            int num = lost[i]-1;
            students[num] -=1;
        }
        for(int i=0;i<reserve.length;i++){
            int num = reserve[i] -1;
            students[num] +=1;
        }
        for(int i=0;i<n-1;i++){
            if(students[i] ==-1 && students[i+1] ==1){
                students[i] = 0 ;
                students[i+1] = 0;
            }
        }
        for(int i=0;i<n-1;i++){
            if(students[i] ==1 && students[i+1] ==-1){
                students[i] = 0 ;
                students[i+1] = 0;
            }
        }

        return (int) Arrays.stream(students).filter(value -> value==0||value==1).count();
    }
    @Test
    public void test(){
        try{
            Assert.assertEquals(5,solution(5,new int[]{2,4},new int[]{1,3,5}));
            Assert.assertEquals(4,solution(5,new int[]{2,4},new int[]{3}));
            Assert.assertEquals(2,solution(3,new int[]{3},new int[]{1}));
            Assert.assertEquals(7,solution(7,new int[]{2,4,5,6,7},new int[]{1,3,4,5,6,7}));
        }catch (Exception e){

        }

    }
}
