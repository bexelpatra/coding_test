package com.test.TEST;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

public class TTest7 {
    public static void main(String[] args) {
        Map<String, Object> map1 = new HashMap<>();
        Map<String, Object> map2 = new HashMap<>();

        map1.put("1", "2");
        map2.put("1", "덮어씌워지나?");
        map2.put("2", "enqjsWpo");

        map1.putAll(map2);

        System.out.println(map1.toString());
        String a = "dd";
        System.out.println(System.currentTimeMillis());
        System.out.println(new Date(1693893726216L).toString());

    }
}
