package com.test.TEST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TTest7 {
    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map1.put("1", "2");
        map2.put("1", "덮어씌워지나?");
        map2.put("2", "enqjsWpo");
        map2.put("3", "=,,=");
        map2.put("4", "asd, 5=adf999");

        map1.putAll(map2);

        System.out.println(map1.toString());
        String a = "dd";
        List<String> list  = new ArrayList<>();
        list.add("asdf");
        list.add("asdf");
        System.out.println(list.toString());
        removePhoto();
        
        test1("asdf");
    }

    private static void removePhoto() {
        String my = "";
        System.out.println(my.replaceAll("[0-9a-zA-Z/+=:\"]", ""));
    }

    private static String mapToString(Map<String,Object> map){
        StringBuilder sb = new StringBuilder();

        return sb.toString();
    }
    private static void test1(String... arg){
        System.out.println(arg.length);
        for (String string : arg) {
            System.out.println(string);
        }
    }
}
