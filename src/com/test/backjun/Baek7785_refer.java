package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baek7785_refer {
  static int n;
    static StringBuilder sb;
    static StringTokenizer st;
    public static void main(String args[]) throws IOException{
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
        n=Integer.parseInt(reader.readLine());
        sb=new StringBuilder();
        Set<String> set=new TreeSet<>();
        while(n-->0){
            st=new StringTokenizer(reader.readLine());
            String name=st.nextToken();
            String a=st.nextToken();
            if(a.equals("enter")){
                set.add(name);
            } else {
                set.remove(name);
            }
        }
        for(Iterator<String> itr=((TreeSet<String>)set).descendingIterator(); itr.hasNext();) {
            sb.append(itr.next()).append("\n");
        }
        System.out.println(sb.toString());
    }

}
