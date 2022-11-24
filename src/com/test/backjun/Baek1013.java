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
}
