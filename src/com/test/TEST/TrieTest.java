package com.test.TEST;

import java.util.HashMap;
import java.util.Map;

public class TrieTest {
    public static void main(String[] args) {
        Trie tr = new Trie();
        tr.insert("abcde");
        tr.insert("abc");
        tr.insert("ab");
        re(tr.node.map);
        System.out.println(sb.toString());
        tr.delete("abc");
        System.out.println(tr.contains("abc"));
        
    }
    static class Node{
        boolean isEnd;
        Map<Character,Node> map = new HashMap<>();
    }
    static class Trie{
        Node node = new Node();

        void insert(String word){
            Node now = this.node;
            for (int i = 0; i < word.length(); i++) {
                now = now.map.computeIfAbsent(word.charAt(i), c->{return new Node();});
            }
            now.isEnd = true;
        }
        boolean contains(String word){
            Node now = this.node;
            for (int i = 0; i < word.length(); i++) {
                if(!now.map.keySet().contains(word.charAt(i))){
                    return false;
                }
                now = now.map.get(word.charAt(i));
            }
            return now.isEnd;
        }
        void delete(String word){
            delete(this.node,word,0);
        }
        void delete(Node node, String word, int idx){
            if(idx == word.length()){
                if(!node.isEnd){
                    // 그런 노드 없음
                }else{
                    node.isEnd = false;
                }
                return;
            }
            
            Node next  = node.map.get(word.charAt(idx));
            if(next == null ){
                // 그런 노드 없음
                return;
            }
            delete(next, word, idx+1);
            if(next.map.size()==0){
                if(!next.isEnd){ // 끝이 아니면
                    node.map.remove(word.charAt(idx),next);
                }
            }

        }
    }
    static StringBuilder sb = new StringBuilder();
    static void re(Map<Character,Node> map){
        for (char key : map.keySet()) {
            sb.append(key).append(" ");
            Node next = map.get(key);
            if(next.isEnd){
                sb.append("|");
            }
            if(next!=null){
                re(next.map);
            }
        }
    }
}
