package com.test.TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TTest23 {
    public static void main(String[] args) {
        int n = 10;
        n-=1;
        while(n -->0){
            System.out.println(n);
        }
        char[] arr= "bxaenq".toCharArray();
        System.out.println(check(arr));
        Arrays.sort(arr);
        System.out.println(check(arr));
        List<String> list = new ArrayList<>();
        list.add("mpxz");
        list.add("abcd");
        list.add("wlmf");
        list.add("jkeq");
        list.add("qplc");
        System.out.println(gridChallenge(list));
    }
    public static boolean check(char[] temp){
        String n = new String(temp);
        for (int i = 0; i < n.length()-1; i++) {
            if(n.charAt(i) > n.charAt(i+1)) return false;
        }
        return true;
    }
    public static String gridChallenge(List<String> grid) {
        // Write your code here
            List<char[]> list= new ArrayList<>();
            for (String str : grid) {
                char[] now = str.toCharArray();
                Arrays.sort(now);
                list.add(now);
            }
            
            for (int i = 0; i < list.size(); i++) {
                char[] now = new char[list.size()];
                for (int j = 0; j < now.length; j++) {
                    now[j] = list.get(j)[i];
                }
                if(!check(now)){
                    return "NO";
                }
            }
            return "YES";
    }
}
