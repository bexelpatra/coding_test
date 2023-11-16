package com.test.TEST;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.test.backjun.Baek1057;
import com.test.backjun.Baek1057_compare;
import com.test.backjun.Baek1261;
import com.test.backjun.Baek1261_compare;
import com.test.backjun.Baek1654;
import com.test.backjun.Baek1654_refer;
import com.test.backjun.BaekImpl;

public class CompareTest {
    public static void main(String[] args) throws Exception {
        Random random = new Random(System.currentTimeMillis());

        // BufferedReader reader = new BufferedReader(new InputStreamReader(new
        // ByteArrayInputStream(sb.toString().getBytes())));
        // getR2(random);
        // get1261(random);
        String a = "";
        StringBuilder sb = new StringBuilder();
        int max = 99;
        int p = random.nextInt(max) + 2;
        int x = random.nextInt(p) + 1;
        int y = random.nextInt(p) + 1;
        if (x == y) {
            x += 1;
        }

        sb.append(p).append(" ").append(x).append(" ").append(y);
        a = sb.toString();
        while (true) {
            int aaa = new Baek1057()
                    .getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(a.getBytes()))));
            int bbb = new Baek1057_compare()
                    .getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(a.getBytes()))));
            if (aaa != bbb) {
                System.out.println(aaa);
                System.out.println(bbb);
                System.out.println(a);
                break;
            }
            sb = new StringBuilder();
            p = random.nextInt(max) + 2;
            x = random.nextInt(p) + 1;
            y = random.nextInt(p) + 1;
            if (x == y) {
                x += 1;
            }
            sb.append(p).append(" ").append(x).append(" ").append(y);
            a = sb.toString();
        }
        ;

    }

    private static void get1261(Random random) {
        int y = random.nextInt(10) + 3;
        int x = random.nextInt(10) + 3;
        StringBuilder sb = new StringBuilder();
        sb.append(y).append(" ").append(x).append("\n");
        int[][] map = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = random.nextBoolean() ? 0 : 1;
            }
        }
        map[0][0] = 0;
        map[y - 1][x - 1] = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        String input = sb.toString();
        while ("".equals(compare(new Baek1261(), new Baek1261_compare(), input))) {
            input = getInput(random);
        }
        System.out.println(input);
    }

    private static String getInput(Random random) {
        int y = random.nextInt(10) + 2;
        int x = random.nextInt(10) + 2;
        StringBuilder sb = new StringBuilder();
        sb.append(y).append(" ").append(x).append("\n");
        int[][] map = new int[y][x];
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = random.nextBoolean() ? 0 : 1;
            }
        }
        map[0][0] = 0;
        map[y - 1][x - 1] = 0;
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    private static void getR2(Random random) throws Exception {
        Baek1654 a = new Baek1654();
        Baek1654_refer b = new Baek1654_refer();

        long r1 = 0;
        long r2 = 0;
        while (r1 == r2) {
            StringBuilder sb = new StringBuilder();
            int n = random.nextInt(10) + 1;
            int m = random.nextInt(100) + 1;
            int[] arr = new int[n];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = random.nextInt(Integer.MAX_VALUE - 1) + 1;
            }
            sb.append(n).append(" ").append(m).append("\n");
            for (int i : arr) {
                sb.append(i).append("\n");
            }

            r1 = a.getResult(
                    new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));
            r2 = b.getResult(
                    new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));

            if (r1 != r2) {
                System.out.println(r1);
                System.out.println(r2);
                System.out.println(sb.toString());
                break;
            }
        }
    }

    public static String compare(BaekImpl<String> a, BaekImpl<String> b, String input) {
        String result = "";
        try {
            String ra = a
                    .getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))));
            String rb = b
                    .getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(input.getBytes()))));
            if (!ra.equals(rb)) {
                result += ra + "\n";
                result += rb;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(input);
        }
        return result;
    }

}
