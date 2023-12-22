package com.test.TEST;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TTest16 {
    public static void main(String[] args) {
        TreeMap<Integer,String> map = new TreeMap<>();
        map.put(1, "1");
        map.put(2, "12");
        map.put(3, "123");
        map.put(7, "123");

        System.out.println(map.lowerKey(6));
        System.out.println(map.ceilingKey(5));
        
        StringBuilder sb  = new StringBuilder();
        for (byte b : "bddd".getBytes()) {
            sb.append(b).append(",");
        }
        System.out.println(sb.toString());

        List<String> list = new ArrayList<>();
        list.add("911");
        list.add("9011");
        list.add("9111");
        Collections.sort(list);
        list.forEach((String t) ->sb.append(t).append("\n"));
        System.out.println(sb.toString());
        Node node = new Node();
        re(node.map);
        // System.out.println(ssb.toString());
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(1, "있음 ");
        map2.computeIfAbsent(1, key->{
            return String.valueOf(key*3);
        });
        map2.computeIfPresent(1, (a,b)->{
            return b + "추가";
        });
        map2.computeIfPresent(1, (a,b)->{
            return b + "추가";
        });

        map2.forEach((t, u) ->System.out.println(t + " : "+ u) );

        
        
        
    }
    static StringBuilder ssb = new StringBuilder();
    static void re(Map<Character,Node> map){
        for (char key : map.keySet()) {
            ssb.append(key).append(" ");
            Node next = map.get(key);
            if(next!=null){
                re(next.map);
            }
        }
    }



    static class Node{
        Map<Character,Node> map = new HashMap<>(); // root
        boolean isEnd;
    }

    static class Trie{

    }
}
