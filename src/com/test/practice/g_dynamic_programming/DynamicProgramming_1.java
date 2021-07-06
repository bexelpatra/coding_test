package com.test.practice.g_dynamic_programming;

import java.util.HashSet;
import java.util.Set;

public class DynamicProgramming_1 {

    public static int solution(int N, int number) {
        Set<Integer> set = new HashSet<>();
        cal(N,number,set,0,0,"");
        return set.stream().sorted().findFirst().orElse(0);
    }
//    static void dfs(int n, int number, int idx, int sum) {
    static void cal(int n,int number,Set<Integer> set,int count,int sum,String x) {
        if(count > 8){
            return;
        }
        if(sum == number){
            set.add(count);
        }
        System.out.println(x);
//        System.out.println(count);
        for (int i = 1; i <= 8; i++) {
            cal(n,number,set,count+i,sum+n,x+"+"+n);
            cal(n,number,set,count+i,sum-n,x+"-"+n);
            cal(n,number,set,count+i,sum*n,x+"*"+n);
            cal(n,number,set,count+i,sum/n,x+"/"+n);
        }
    }
    public static int solution2(int N, int number) {
        dfs(N, number, 0, 0);
        if (answer > 8)
            return -1;
        return answer;
    }

    static int answer = Integer.MAX_VALUE;
    static void dfs(int n, int number, int idx, int sum) {
        if (idx > 8){
            return;
        }
        if (sum == number) {
            answer = Math.min(idx, answer);
        }
        int temp = 0;
        for (int i = 1; i <= 8; i++) {
            temp = temp * 10 + n;
            dfs(n, number, idx + i, sum + temp);
            dfs(n, number, idx + i, sum - temp);
            dfs(n, number, idx + i, sum / temp);
            dfs(n, number, idx + i, sum * temp);
        }
    }
}
