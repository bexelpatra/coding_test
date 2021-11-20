package com.test.practice.h.binary_search;

import java.util.Arrays;

public class BinarySearch_6 {

    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)n*(long)times[times.length-1];
        long min = 0;
        long answer = 0;
        while(min <= max){
            long middle = (min + max) /2;
            if(getN(middle,times) <n){
                min = middle + 1;
            }else{
                max = middle -1;
                answer = middle;
            }
        }
        return answer;
    }

    public long getN(long time, int[] times){
        long x = 0;
        for (int i : times) {
            x+=time/i;
        }
        return x;
    }

    /**
     *  dfs로 이분탐색을 시도했다.
     *  퀵정렬 비스무리하게 하려고 했는데 마음같지 않다.
     */
    static long a =Integer.MAX_VALUE;
    public long solution2(int n, int[] times) {
        Arrays.sort(times);
        long max = (long)n*(long)times[0];
        long min = 0;
        a = max;
        extracted(n, times, max, min);

        return a;
    }
    private void extracted(int n, int[] times, long max, long min) {
        long pass =0;
        long pivot = min + (max-min)/2;

        pass = calculation(pivot, times);
        if(pivot - min == 0) {
            return;
        }
        if(pass > n) {
            max = pivot;
            a = Math.min(a, pivot);
        }else if(pass == n){
            min = pivot;
            a = Math.min(a, pivot);
        }else if(pass < n) {
            min = pivot;
        }
        extracted(n, times, max, min);
    }
    public long calculation(long time, int[] times) {
        long rtn = 0 ;
        for (int i = 0; i < times.length; i++) {
            rtn += time/times[i];
        }
        return rtn;
    }
}
