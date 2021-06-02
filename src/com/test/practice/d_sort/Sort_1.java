package com.test.practice.d_sort;

import java.util.Arrays;

public class Sort_1 {
    public int[] solution(int[] array, int[][] commands) {
        int i=0;
        int[] answer = new int[commands.length];
        for (int[] command : commands) {
            int start = command[0]-1;
            int end = command[1];
            int peek = command[2];

            answer[i] =Arrays.stream(array,start,end).sorted().toArray()[peek-1];
            i++;
        }
        return answer;
    }

    /*
        프로그래머스에서 본 내용, quick sort를 직접 구현
     */
    public int[] solution2(int[] array, int[][] commands) {
        int n = 0;
        int[] ret = new int[commands.length];

        while(n < commands.length){
            int m = commands[n][1] - commands[n][0] + 1;

            if(m == 1){
                ret[n] = array[commands[n++][0]-1];
                continue;
            }

            int[] a = new int[m];
            int j = 0;
            for(int i = commands[n][0]-1; i < commands[n][1]; i++)
                a[j++] = array[i];

            sort(a, 0, m-1);

            ret[n] = a[commands[n++][2]-1];
        }

        return ret;
    }

    public void sort(int[] a, int left, int right){
        int pl = left;
        int pr = right;
        int x = a[(pl+pr)/2];

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr){
                int temp = a[pl];
                a[pl] = a[pr];
                a[pr] = temp;
                pl++;
                pr--;
            }
        }while(pl <= pr);

        if(left < pr) sort(a, left, pr);
        if(right > pl) sort(a, pl, right);
    }
}
