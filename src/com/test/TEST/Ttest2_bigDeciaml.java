package com.test.TEST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Ttest2_bigDeciaml {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        int c7 = Integer.parseInt(st.nextToken());
        int c8 =Integer.parseInt(st.nextToken());
        // int c7 = 3;
        // int c8 =3;
        BigDecimal b = new BigDecimal(1);

        for (int i = 0; i < c8; i++) {
            b = b.multiply(BigDecimal.valueOf(c7 -i));   
        }
        for (int i = 0; i < c8; i++) {
            b = b.divide(BigDecimal.valueOf(i+1));   
        }
        b = b.remainder(BigDecimal.valueOf(10007));
        System.out.println(b);
        // calc(c7, c8);
        
        for (int n = 2; n < 7; n++) {
            
            for (int i = 0; i < n; i++) {
                
                calc(n, i+1);
                // calc(5, 5);
            }
            System.out.println();
        }
    }
    public static void calc(int start,int k){
        int m =1;
        int s = 1;
        
        int temp = k;
        while(k-->0){
            m*= start-k;
            s *= k+1;
        }

        System.out.printf("%d %d => %d\n",start,temp,m/s);
    }
}
