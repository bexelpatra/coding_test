package com.test.ETC;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Streamtest {
    public static void main(String[] args) throws Exception {
        List<Map<String, String>> list = new ArrayList<>();
        list.stream().filter(t -> INTEQ.GTE.compare(Integer.parseInt(t.get("tran_nm")), 5000));

        System.out.println("-------------------------------------");

    }

    // public static Predicate<Map<String, String>> predicateInt(String col, INTEQ
    // iq, int val) {
    // return t -> {
    // String colVal = t.getOrDefault(col, "");
    // if (colVal.equals("")) {
    // return true;
    // } else {
    // int colInt = Integer.parseInt(colVal);
    // if (iq == INTEQ.EQ) {

    // }
    // }
    // };
    // }
}
