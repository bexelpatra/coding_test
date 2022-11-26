package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

public class Baek1013 {
    // 1. 정규식으로 푸는 방법
    // 2. 오토마타 ? 처음 듣는 방법, 문자열을 하나씩 읽어나가며서 상태를 바꾼다. 모로가도 안되는 상태가 되면 끝...
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        (100+1+ | 01)+
//        regex(reader);
        automata(reader);
    }
    public static void regex(BufferedReader reader) throws Exception{
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        Pattern p = Pattern.compile("^(100+1+|01)+$");

        for (int i = 0; i < n; i++) {
            String v = reader.readLine();
            if(p.matcher(v).matches()){
                sb.append("yes");
                sb.append("\n");
            }else{
                sb.append("no");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }
    public static void automata(BufferedReader reader)throws Exception {
        int n = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        // auto의 첫번째 array는 상태값
        // auto의 상태값 안의 값은 입력값에 따른 다음 상태로 전이할 상태값
        // 조건에 부합하지 않는 문자열은 -1 반환

        int[][] auto = new int[][]{
            {1,2},// 상태 0
            {-1,3},// 상태 1
            {4,-1},// 2
            {1,2},// 3
            {5,-1},// 4
            {5,6},// 5
            {1,7},// 6
            {8,7},// 7
            {5,0},// 8
        };
        for (int i = 0; i < n; i++) {
            String v = reader.readLine();
            int state =0 ;
            for (int j = 0; j < v.length(); j++) {
                state = auto[state][v.charAt(j)-'0'];
                if (state <0){
                    break;
                }
            }
            if(state ==0|| state ==3 || state==6 || state==7){
                sb.append("YES");
                sb.append("\n");
            }else{
                sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb.toString());
    }

}
