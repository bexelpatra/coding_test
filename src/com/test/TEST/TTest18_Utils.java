package com.test.TEST;

import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

public class TTest18_Utils {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String temp = "000000000000000"+String.valueOf((int)(Math.random()*1000000));
        sb = new StringBuilder(temp);
        removeZero(sb);
        System.out.println(sb.toString());
        sb = new StringBuilder(temp);
        removeZero2(sb);
        System.out.println(sb.toString());
        Map<String,Object> map = new HashMap<>();
        System.out.println("000".equals(map.get("result")));
        System.out.println("000".equals(null));
        System.out.println(map.get("result")==null);

        ZonedDateTime now = ZonedDateTime.now();
        ZonedDateTime next = now.plusMinutes(-1000);
        System.out.println(now.toEpochSecond());
        System.out.println(next.toEpochSecond());

        System.out.println(('b'+'a' - 'a'*2));
    }
    static void removeZero(StringBuilder sb){
        int idx = 0;
        for (int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)=='0') idx++;
        }
        if(idx == sb.length()){
            sb.setLength(0);
            sb.append('0');
            return;
        }

        int i = 0;
        for (i = 0; i < sb.length(); i++) {
            if(sb.charAt(i)!= '0'){
                break;
            }
        }
        sb.delete(0, i);
    }

    static void removeZero2(StringBuilder sb){
        int idx = 0;
        while(sb.charAt(idx)=='0'){
            idx+=1;
            if(idx == sb.length()){
                sb.setLength(0);
                sb.append('0');
                return;
            }
        }
        sb.delete(0, idx);
    }
    static void reverse(char[] arr , int start, int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start+=1;
            end+=1;
        }
    }
}
