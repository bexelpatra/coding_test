package com.test.TEST;

import java.util.ArrayList;
import java.util.List;

public class LastIndexTest {
    public static void main(String[] args) {
        String a = "select a as ac8,b,c from ( select a,b,c from c where 1 = 1 ) a inner join tb_merc b on b.id = a.a where 1=1 and a.regist = (select regist from c8 where day = '28')";
        int sel = 0;
        int from = 0;
        List<Integer> selList = new ArrayList<>();
        List<Integer> fromList = new ArrayList<>();
        int idx = 0;
        while ((sel = a.indexOf("select", idx)) > -1) {
            selList.add(sel);
            idx = sel + 1;
        }

        idx = 0;
        while ((from = a.indexOf("from", idx)) > -1) {
            fromList.add(from);
            idx = from + 1;
        }
        for (int i = 0; i < selList.size(); i++) {
            System.out.println(a.substring(selList.get(i), fromList.get(i) + 4));
            if (i + 1 == selList.size()) {
                System.out.println(a.substring(fromList.get(i) + 4));
            } else {
                System.out.println(a.substring(fromList.get(i) + 4, selList.get(i + 1)));
            }
        }

    }
}
