package com.test.TEST;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TTest6 {
    public static void main(String[] args) {
        // grep '\(07:48:33\|07:48:32\|07:48:31\|07:48:30\).[0-9]\{1,\}
        // \[http-nio-5200-exec-6\]'
        String[] arr = "07:48:33.175[http-nio-5200-exec-7]@09:25:01.488[http-nio-5200-exec-8]@13:33:10.712[http-nio-5200-exec-5]@14:39:17.006[http-nio-5200-exec-7]@14:48:09.264[http-nio-5200-exec-7]@15:58:38.036[http-nio-5200-exec-1]@16:35:06.081[http-nio-5200-exec-9]@16:52:55.411[http-nio-5200-exec-7]@17:07:24.580[http-nio-5200-exec-1]@17:14:37.883[http-nio-5200-exec-9]@18:26:58.232[http-nio-5200-exec-3]@"
                .split("@");
        for (String string : arr) {
            // getTime(string);
        }
        getTime("10:10:44.378 [http-nio-5200-exec-4]");
    }

    private static void getTime(String e) {
        e = e.replaceAll("\\s", "");
        e = e.replaceAll("\\[", "\\\\[");
        e = e.replaceAll("\\]", "\\\\]");
        System.out.println();
        StringBuilder sb = new StringBuilder();
        sb.append("grep '");
        int h = Integer.parseInt(e.substring(0, 2));
        int m = Integer.parseInt(e.substring(3, 5));
        int s = Integer.parseInt(e.substring(6, 8));
        int ss = Integer.parseInt(e.substring(9, 12));

        ZonedDateTime time = ZonedDateTime.of(2000, 1, 1, h, m, s, ss, ZoneId.systemDefault());
        sb.append("\\(");
        for (int i = 0; i < 21; i++) {
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
        System.out.println(sb.toString());
    }
}
