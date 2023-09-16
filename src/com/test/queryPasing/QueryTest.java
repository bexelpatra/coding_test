package com.test.queryPasing;

import java.util.List;

public class QueryTest {
    public static void main(String[] args) {
        String sample = "select a, (select b from c) from table where 1=1 and ddd = (select dd from tb_d where dd = (select sys from tb where 1=1)) ";
        List<Integer> select = TuningUtils.keywords(sample, "select");
        List<Integer> from = TuningUtils.keywords(sample, "from");
        List<Integer> where = TuningUtils.keywords(sample, "where");
        

    }
}
