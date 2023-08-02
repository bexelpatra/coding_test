package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import sun.applet.Main;

public class Baek17413 {
    public static void main(String[] args) throws Exception {
        String a = "one1 two2 three3 4fourr 5five 6six";
        // String a = "1eno 2owt 3eerht rruof4 evif5 xis6";
        // solveBySplit(a);
    }

    private static void solveBySplit(String a) {
        StringBuilder sb = new StringBuilder();
        for (String string : a.split("<")) {
            int index = string.indexOf(">");
            if (index > -1) {
                sb.append("<" + string.substring(0, index + 1));
                String[] next = string.substring(index + 1).split(" ");
                for (String word : next) {
                    for (int i = word.length() - 1; i >= 0; i--) {
                        sb.append(word.charAt(i));
                    }
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
            } else {
                String[] next = string.substring(index + 1).split(" ");
                for (String word : next) {
                    for (int i = word.length() - 1; i >= 0; i--) {
                        sb.append(word.charAt(i));
                    }
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
            }
        }

        System.out.println(sb.toString());
    }

    private static void firstShot(BufferedReader reader) throws IOException {
        StringBuilder main = new StringBuilder();
        StringBuilder temp = null;
        int now = 0;
        // System.out.println((int) ' ');
        boolean flag = false;
        while ((now = reader.read()) > -1) {
            if ((char) now == '<') {
                main.append((char) now);
                while ((now = reader.read()) != (int) '>') {
                    main.append((char) now);
                }
                main.append((char) now);
            } else {
                temp = new StringBuilder();
                temp.append((char) now);
                while ((now = reader.read()) != (int) ' ') {
                    if (now == 10 || now == 13) {
                        flag = true;
                        break;
                    } else if (now == (int) '<') {

                    }
                    temp.append((char) now);
                }
                main.append(temp.reverse());
                main.append(' ');
            }
            if (flag) {
                break;
            }
        }
        System.out.println(main.toString());
    }

    // https://www.acmicpc.net/source/35356628
    private static void reference_1(BufferedReader reader) throws IOException {
        char[] chars = reader.readLine().toCharArray();
        int idx = 0;
        while (idx < chars.length) {
            if (chars[idx] == '<') {
                while (chars[idx++] != '>') { // idx 숫자만 올린다.
                }
            } else if (Character.isLetterOrDigit(chars[idx])) {
                int start = idx;
                while (idx < chars.length && chars[idx] != '<' && chars[idx] != ' ') {
                    idx += 1;
                }
                int end = idx - 1;
                reverse(chars, start, end);
                if (idx < chars.length && chars[idx] != '<') {
                    idx += 1;
                }
            }
        }
        System.out.println(chars);
    }

    private static void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[start] = temp;
            start += 1;
            end -= 1;
        }
    }

}
