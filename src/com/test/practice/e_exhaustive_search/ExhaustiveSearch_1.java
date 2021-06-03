package com.test.practice.e_exhaustive_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class ExhaustiveSearch_1 {
    public int[] solution(int[] answers) {

        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] answer = new int[3];

        for(int i=0; i < answers.length;i++){
            if(answers[i] == nextInt(a,i)) answer[0]++;
            if(answers[i] == nextInt(b,i)) answer[1]++;
            if(answers[i] == nextInt(c,i)) answer[2]++;
        }

        int max = Arrays.stream(answer).max().orElse(0);
        List<Integer> integers = new ArrayList<>();
        if(max == answer[0]) integers.add(1);
        if(max == answer[1]) integers.add(2);
        if(max == answer[2]) integers.add(3);

        return integers.stream().mapToInt(Integer::intValue).toArray();
    }
    public int[] solution2(int[] answers) {

        int[] a = new int[]{1,2,3,4,5};
        int[] b = new int[]{2,1,2,3,2,4,2,5};
        int[] c = new int[]{3,3,1,1,2,2,4,4,5,5};

        int[] answer = new int[3];

        for(int i=0; i < answers.length;i++){
            if(answers[i] == a[i%a.length]) answer[0]++;
            if(answers[i] == b[i%b.length]) answer[1]++;
            if(answers[i] == c[i%c.length]) answer[2]++;
        }
        int max = Arrays.stream(answer).max().orElse(0);

        int max2 = Math.max(answer[0],Math.max(answer[1],answer[2]));
        List<Integer> ans = new ArrayList<>();
        for (int i =0;i<answer.length;i++) {
            if(max == answer[i]) ans.add(i+1);
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    private int nextInt(int[] pattern, int now){
        int len = pattern.length;
        if(len == now){
            now=0;
        }
        return pattern[now];
    }
    class Student{
        private int id;
        private int count=0;
        private int[] pattern;
        public Student(int id,int[] pattern) {
            this.id = id;
            this.pattern = pattern;
        }
        public int getCount() { return count; }public void setCount(int count) { this.count = count; }public void addCount(){ this.count++; }public int getId() { return id; }
    }
}
