package com.test.utils;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class TimeoutLogFind {
    public static void main(String[] args) {
        // grep '\(07:48:33\|07:48:32\|07:48:31\|07:48:30\).[0-9]\{1,\}
        // \[http-nio-5200-exec-6\]'
        String[] arr = "08:10:09.385 [http-nio-5200-exec-1] "
                .split("@");
                        
        for (String string : arr) {
            StringBuilder sb = new StringBuilder();
            sb.append("grep").append(" -B20 ")
            .append(getTime(string, 21))
            .append(" catalina.out")
            ;
            System.out.println(sb.toString());
        }
        // getTime("10:10:44.378 [http-nio-5200-exec-4]");
    }

    private static String getTime(String e, int sec) {
        e = e.replaceAll("\\s", "");
        e = e.replaceAll("\\[", "\\\\[");
        e = e.replaceAll("\\]", "\\\\]");
        System.out.println();
        StringBuilder sb = new StringBuilder("'");
        int h = Integer.parseInt(e.substring(0, 2));
        int m = Integer.parseInt(e.substring(3, 5));
        int s = Integer.parseInt(e.substring(6, 8));
        int ss = Integer.parseInt(e.substring(9, 12));

        ZonedDateTime time = ZonedDateTime.of(2000, 1, 1, h, m, s, ss, ZoneId.systemDefault());
        sb.append("\\(");
        for (int i = 0; i < sec; i++) {
            // System.out.println(time.minusSeconds(i).toLocalTime().toString().split("\\.")[0]);
            sb.append(time.minusSeconds(i).toLocalTime().toString().split("\\.")[0]).append("\\|");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("\\).");
        sb.append("[0-9]\\{3\\} ")
                .append(e.substring(12))
        ;
        sb.append("'");
        return sb.toString();
    }
}
