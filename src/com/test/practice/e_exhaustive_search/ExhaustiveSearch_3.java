package com.test.practice.e_exhaustive_search;

public class ExhaustiveSearch_3 {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int total = brown+yellow;
        int x = 0;
        int y = 3;

        int b = 0;
        int r = 0;

        for(int i= y; i<total ; i++){
            if(total%i == 0){
                x = total/i;
                y = i;
                b = (x+y-2)*2;
                r = x*y -b;
                if(brown == b && yellow == r && x>=y) {
                    return new int[]{x,y};
                }
            }
        }
        return answer;
    }
}
