package com.test.queryPasing;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TTest3 {
    public static void main(String[] args) throws Exception{
        String os = System.getProperty("os.name").toLowerCase();
        Runtime r = Runtime.getRuntime();
        Process p = null;
        System.out.println(os);
        if(os.contains("win")){
            p = r.exec("cmd /c ",args);
        }else if(os.contains("linux")){
            p = r.exec("/bin/sh -c",args);
        }
        if(p == null){
            System.out.println("runtime failed");
        }
        
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        int now = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        while((now=reader.read())>-1){
            char n = (char)now;
            sb.append(n);
            if(n == '"'){
                String param = temp.toString();
                boolean flag= true;
                temp = new StringBuilder();
                if(param.equals("drvLcnsePhoto")){
                    flag = false;
                    temp.append("skip");
                }
                while((n = (char)reader.read())!='"'){
                    if(flag){
                        temp.append(n);
                        sb.append(n);
                    }
                }
            }
        }
        System.out.println(sb.toString());
    }
}
