package com.test.TEST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.test.utils.testfile.TempDto;

public class TTest21 {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("a", "b");
        TempDto temp = new TempDto(map);
        map.put("ab", "c");
        temp.test();
        temp.newOne();
        System.out.println("뉴원 다음에");
        map.put("c", "8");
        StringBuilder sb = new StringBuilder();
        map.forEach((t, u) -> sb.append(t).append(" : ").append(u).append("\n"));
        System.out.println(sb.toString());
        System.out.println();
        temp.test();

        String[] my = new String[]{"1","2","3"};

        System.out.println(String.format("%s %s", my));
        float a = 3;
        
        System.out.println(String.format("%.6f", 5f/3));

        String t ="dd";
        // String t ="24";
        char[] tr = t.toCharArray();
        int place = -1;
        int value = -1;
        int nextValue = -1;
        int nextPlace = -1;
        
        for (int i = 0; i < tr.length-1; i++) {
            int now= tr[i];
            int next= tr[i+1];
            if(now < next){
                place = i;
                value = now;
                nextPlace = i+1;
                nextValue = next;
            }
            if(next < nextValue && next > value){
                nextValue = next;
                nextPlace = i+1;
            }
        }

        if(nextPlace ==-1){
            System.out.println("대츠 노노");
        }else{
            swap(tr, place, nextPlace);
            char[] sett= cut(tr, place);
            Arrays.sort(sett);
            set(tr, sett, place+1);
            System.out.println("@@@ "+new String(tr));
            System.out.println(String.format("%s [%d] %c [%d] %c",t, place,value,nextPlace,nextValue));
        }
        int n = 73;
        System.out.println((n/5 + 1)*5);
        
        
    }
    public static char[] cut(char[] cs, int start){
        int len = cs.length - start - 1;
        if(len <0){
            return null;
        }
        char[] temp = new char[len];
        for (int i = 0; i < len; i++) {
            temp[i] = cs[i+start+1];
        }
        return temp;

    }
    public static void swap(char[] cs, int a, int b){
        char temp = cs[a];
        cs[a] = cs[b];
        cs[b] = temp;
    }
    public static void set(char[] cs, char[] temp, int start){
        for (int i = 0; i < temp.length; i++) {
            cs[i+start] = temp[i];
        }
    }
}
