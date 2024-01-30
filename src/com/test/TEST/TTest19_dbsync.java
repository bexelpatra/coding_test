package com.test.TEST;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class TTest19_dbsync {
    public static void main(String[] args) throws IOException {
        BufferedReader dev = new BufferedReader(new InputStreamReader(new FileInputStream("d:/dev.txt")));
        BufferedReader prod = new BufferedReader(new InputStreamReader(new FileInputStream("d:/prod.txt")));

        String line = "";
        Map<String,Set<String>> devMap = new HashMap<>();
        while((line= dev.readLine())!=null){
            String[] a = line.split("\t");
            Set<String> set = devMap.computeIfAbsent(a[0], t -> new HashSet<>());
            set.add(a[1]);
            devMap.put(a[0], set);
        }
        
        Map<String,Set<String>> prodMap = new HashMap<>();
        while((line= prod.readLine())!=null){
            String[] a = line.split("\t");
            Set<String> set = prodMap.computeIfAbsent(a[0], t -> new HashSet<>());
            set.add(a[1]);
            devMap.put(a[0], set);
        }
        
        Map<String,Set<String>> diffMap = new HashMap<>();
        for (String key : devMap.keySet()) {
            Set<String> devSet = devMap.get(key);
            Set<String> prodSet = prodMap.get(key);
            if(prodSet == null ){
                diffMap.put(key, devSet);
                continue;
            }
            Set<String> diff = new HashSet<>();
            for (String s : devSet) {
                if(!prodSet.contains(s)){
                    diff.add(s);
                }
            }
            if(diff.size()>0){
                diffMap.put(key, diff);
            }
        }

        for (String key : diffMap.keySet()) {
            System.out.println(key);
            System.out.println(Arrays.toString(diffMap.get(key).toArray()));
            System.out.println();
        }
        
    }
}
