package com.test.TEST;
import java.util.TreeMap;

public class TTest16 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1, "1");
        map.put(2, "12");
        map.put(3, "123");
        map.put(7, "123");

        System.out.println(map.lowerKey(6));
        System.out.println(map.ceilingKey(5));
        
        StringBuilder sb  = new StringBuilder();
        for (byte b : "MLDDEVSAMPLEKEY!".getBytes()) {
            sb.append(b).append(",");
        }
        System.out.println(sb.toString());
    }
}
