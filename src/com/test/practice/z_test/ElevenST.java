package com.test.practice.z_test;

// import org.junit.Assert;
// import org.junit.Test;

import java.util.Arrays;

public class ElevenST {
    public int solution(int[] A) {
        // write your code in Java SE 8
        int ans = 1;
        Arrays.sort(A);
        int negative = 0;
        for(int i=0;i<A.length-1;i++){
            if(A[i]<0) {
                negative+=1;
                continue;
            }
            if(A[i] +1 != A[i+1] && !(A[i]==A[i+1])){
                return A[i]+1;
            }
        }
        if(negative == A.length-1) return 1;
        return A[A.length-1]+1;
    }


    public boolean solution(int[] A, int K) {
        int n = A.length;
        // 같거나 작음 안되는거지
        for (int i = 0; i < n - 1; i++) {
            if (A[i] + 1 < A[i + 1]){
                System.out.println("틀림1");
                return false;
            }
        }
        // 마지막 A가 k가 아니다? k 일수도 있는거지
        if (A[0] != 1 || A[n - 1] != K){
            System.out.println("틀림2");
            return false;
        }
        else{
            System.out.println("맞음");
            return true;
        }
    }

    public int solution(int N) {
        // write your code in Java SE 8
        String[] temp = String.valueOf(N).split("");
        int[] numbers = new int[temp.length];
        int sum = 0;
        for(int i=0;i<numbers.length;i++){
            int n = Integer.parseInt(temp[i]);
            numbers[i] = n;
            sum+= n;
        }

        while(true){
            N+=1;
            int result = sums(N);
            if(result == sum){
                return N;
            }
        }
    }
    public int sums(int n){
        String[] temp = String.valueOf(n).split("");
        int sum = 0;
        for(int i=0;i<temp.length;i++){
            sum+= Integer.parseInt(temp[i]);
        }
        return sum;
    }
}
