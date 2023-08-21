package com.test.utils;

public class Utils {
    public static String br(String str,int n){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(str);
        }
        return sb.toString();
    }
}
