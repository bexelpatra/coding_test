package com.test.utils.testfile;

import java.util.HashMap;
import java.util.Map;

public class TempDto {
    private Map<String,String> map;

    public TempDto(Map<String, String> map) {
        this.map = map;
    }
    public void test(){
        StringBuilder sb = new StringBuilder();
        sb.append("테스트다요");
        map.forEach((t, u) -> sb.append(t).append(" : ").append(u).append("\n"));
        System.out.println(sb.toString());
    }
    public void newOne(){
        map = new HashMap<>();
    }
}
