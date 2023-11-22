package com.test.backjun.Barkindog;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1074__2 {

    static int n;
    static int r;
    static int c;    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        recur(2<<n, r, c);
        System.out.println(count);
    }
    static int count = 0;
    public static void recur(int len,int y , int x){
        if(len ==1){
            return;
        }
        int next = len/2;
        boolean left =  x < next;
        boolean right = x>= next;
        boolean top = y < next;
        boolean bottom = y >=next;
        if(right&&top){
            count+= next*next;
            recur(next, y, x- next);
        }else if(right&&bottom){
            count+= next*next *3;
            recur(next, y - next, x-next);
        }else if( left&&bottom){
            count+= next*next*2;
            recur(next, y-next, x);
        }else if(left&& top){
            recur(next, y, x);
        }
    }

}
