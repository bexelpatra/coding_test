package com.test.practice.e_exhaustive_search;

import java.util.*;
import java.util.stream.Collectors;

public class ExhaustiveSearch_2 {
    public int solution(String numbers) {
        int answer = 0;
//        int[] number = new int[numbers.length()];
//        int i=0;
//        for(char c : numbers.toCharArray()){
//            number[i++] = Integer.parseInt(String.valueOf(c));
//        };
        Set<String> set = new HashSet<>();
        for(int i=1;i<numbers.length()+1;i++){
            int j = 0;
            while (j<i){
                String.valueOf(numbers.charAt(i));
            }
        }
        return answer;
    }

    public int solution2(String numbers) {
        List<String> numberList = Arrays.stream(numbers.split("")).collect(Collectors.toList());
        List<String> result = new ArrayList<>();
        Set<Integer> integers = new HashSet<>();
        for(int i=0;i<numbers.length();i++){
            permutation(numberList,new ArrayList<>(),numbers.length(),i+1,integers);
        }
        int count = (int)integers.stream().filter(integer -> {
            for(int i=2;i<Math.sqrt(integer);i++){
                if(integer%i ==0) return false;
            }
            return true;
        }).count();
        System.out.println(count);
        return count;
    }

    private void permutation(List<String> arr,List<String> result,int n,int r,Set<Integer> ints){
        if(r==0){
            StringBuilder builder = new StringBuilder();
            result.stream().forEach(s -> builder.append(s));
            String res = builder.toString();
            int x= Integer.parseInt(res);
            if(x>1){
                ints.add(x);
            }
            return;
        }
        for(int i=0;i<n;i++){
            result.add(arr.remove(i));
            permutation(arr,result,n-1,r-1,ints);
            arr.add(i,result.remove(result.size()-1));
        }
    }
}
