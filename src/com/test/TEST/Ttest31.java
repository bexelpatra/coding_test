package com.test.TEST;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Ttest31 {
    public static void main(String[] args) {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        
        System.out.println(Arrays.toString(list.toArray()));
        String a = "123";
        String b= "456";
        Map<String,Object> map = new HashMap<>();

        System.out.println(map.getOrDefault("123","").toString());
        long now = System.currentTimeMillis();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(133/10%4);
        System.out.println(System.currentTimeMillis() - now);
    }
    public static int binary(List<Integer> list ,int n){
        int hi = list.size()-1;
        
        return 0;
    }
}
