package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Baek5052 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while(loop-->0){
            int n = Integer.parseInt(reader.readLine());
            List<String> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(reader.readLine());
            }
            list.sort((o1, o2) -> {
                return o1.compareTo(o2);
            });

            boolean flag = true;
            for (int i = 0; i < list.size()-1; i++) {
                if(list.get(i+1).startsWith(list.get(i))){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
        // try1_fail(reader);
    }

    private static void try1_fail(BufferedReader reader) throws IOException {
        int loop = Integer.parseInt(reader.readLine());
        StringBuilder sb = new StringBuilder();
        while(loop-->0){
            int n = Integer.parseInt(reader.readLine());
            List<Long> list = new ArrayList<>(n);
            for (int i = 0; i < n; i++) {
                list.add(Long.parseLong(reader.readLine()));
            }
            list.sort(Comparator.naturalOrder());
            boolean flag = true;
            for (int i = 0; i < list.size()-1; i++) {
                if(String.valueOf(list.get(i+1)).startsWith(String.valueOf(list.get(i))) ){
                    flag = false;
                    break;
                }
            }
            if(flag){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }
        System.out.println(sb.toString());
    }
}
