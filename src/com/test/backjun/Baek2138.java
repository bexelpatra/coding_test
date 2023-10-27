package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 다시 푼다면...
 * 0과 1을 바꾸는 것이 언제 확정되는지를 생각해보는게 힌트다.
 */
public class Baek2138 {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        // 1회
        list.add(new Boolean[]{false,true,true,true,false});
        list.add(new Boolean[]{true,true,true,false,false,});
        list.add(new Boolean[]{false,false,true,true,true});

        // 2회
        list.add(new Boolean[]{false,true,false,false,true,});
        list.add(new Boolean[]{true,false,false,true,false,});
        list.add(new Boolean[]{true,true,false,true,true,});
        
        // 3회
        list.add(new Boolean[]{true,false,true,false,true,});


        int n = Integer.parseInt(reader.readLine());
        boolean[] ori = new boolean[n+2];
        String now = reader.readLine();
        for (int i = 0; i < now.length(); i++) {
            ori[i+1] = now.charAt(i) =='0'? false:true;
        }
        boolean[] tar = new boolean[n+2];
        String target = reader.readLine();
        for (int i = 0; i < target.length(); i++) {
            tar[i+1] = now.charAt(i) =='0'? false:true;
        }

        
        
    }
    public static List<Boolean[]> list = new ArrayList<>();
    public static int count = 0;
    public static void change(boolean[] ori, boolean[] tar,int start,int end){
        for (int i = 0; i < list.size(); i++) {
            Boolean[] now = list.get(i);
            for (int j = 0; j < now.length; j++) {
                
            }
        }
    }
}
