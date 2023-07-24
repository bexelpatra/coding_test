package com.test.queryPasing;

import java.util.Date;

public class TTest2 {
    public static void main(String[] args) {
        String q = "WHERE ? = ? AND `RECPTN_DE` = DATE_FORMAT ( SYSDATE ( ) , ? ) AND `BATCH_TRNSMIT_RECPTN_JOB_SE_CODE` = ? AND `BATCH_STTUS_CODE` = ? AND `TRNSMIT_CO` < ? ORDER BY `ODR` ASC"
                .toLowerCase();
        System.out.println(q.split("where").length);
        for (String string : q.split("where")) {
            System.out.println("________________________________");
            System.out.println(string.split("order by").length);
            System.out.println(string.split("join").length);
            System.out.println(string.split("group by").length);
            System.out.println("________________________");
            System.out.println();
        }
        System.out.println();
        long a = new Date().getTime();
        // 1689662880000
        // 1689663282612
        System.out.println(a);
        System.out.println(new Date(a));
        System.out.println(new Date(1689663282612L));

    }
}
/*
 * RECPTN_DE
 * BATCH_TRNSMIT_RECPTN_JOB_SE_CODE
 * ODR
 * BATCH_STTUS_CODE
 * TRNSMIT_CO
 */