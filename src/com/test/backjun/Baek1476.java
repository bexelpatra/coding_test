package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1476 {
    static int e;
    static int s;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        e = Integer.parseInt(st.nextToken()); // 15 
        s = Integer.parseInt(st.nextToken()); // 28
        m = Integer.parseInt(st.nextToken()); // 19
        System.out.println(add());
        
    }

    public static int add(){
        int a = 1;
        int b = 1;
        int c = 1;

        int result = 1;
        while(!(a==e && b==s && m==c)){
            a+=1;
            b+=1;
            c+=1;
            if(a>=16){
                a=1;
            }
            if(b>=29){
                b=1;
            }
            if(c>=20){
                c=1;
            }
            result+=1;
            // System.out.printf("%d %d %d %d \n",a,b,c,result);
        }
        return result;
    }
}
