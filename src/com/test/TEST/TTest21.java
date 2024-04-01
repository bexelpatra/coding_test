package com.test.TEST;

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
        
        
    }
}
