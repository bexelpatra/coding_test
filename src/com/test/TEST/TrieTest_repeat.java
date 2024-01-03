package com.test.TEST;

import java.util.HashMap;
import java.util.Map;

public class TrieTest_repeat {
    public static void main(String[] args) {
        
    }
    static class Node{
        Map<Character,Node> map = new HashMap<>();
        boolean end;
    }
    static class Trie{
        Node root = new Node();
        void insert(String str){
            Node now = this.root;
            for (int i = 0; i < str.length(); i++) {
                now = now.map.computeIfAbsent(str.charAt(i), (key)->new Node());
            }
            now.end = true;
        }

        boolean search(String str){
            Node node = this.root;
            for (int i = 0; i < str.length(); i++) {
                node=node.map.getOrDefault(str.charAt(i), null);
                if(node == null){
                    return false;
                }
            }
            return node.end;
        }
    }
}
