package com.test.practice.f_greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Greedy_2 {
    // 알파벳 변경횟수 + 움지경야되는 횟수
    public int solution(String name) {
        int answer = 0;// A = 65, Z = 90
        int sum = 0;
        List<Integer> integerList = new ArrayList<>();
        for(int i=0;i<name.length();i++){
            int c = name.charAt(i);
            if(c!=65){
                integerList.add(i);
            }
        }
        if(integerList.size()>=2){
            for(int i=0;i<integerList.size()-1;i++){
                sum+=between(integerList.get(i),integerList.get(i+1),name.length());
            }
        }else {

        }
        int a = between(0,2,3);
        return answer;
    }
    public int between(int a, int b,int len){
        int x = a;
        int time = 0;
        while(x!=b){
            x-=1;
            if(x<0){
                x = len-1;
            }
            time+=1;
        }
        return Math.min(b-a, time);
    }
    @Test
    public void test(){
        Assert.assertEquals(0,solution("AZ"));
    }
}
