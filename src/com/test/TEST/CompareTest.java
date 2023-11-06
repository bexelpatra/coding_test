package com.test.TEST;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.test.backjun.Baek1654;
import com.test.backjun.Baek1654_refer;

public class CompareTest {
    public static void main(String[] args) throws Exception {
        Random random = new Random(System.currentTimeMillis());

        
        // BufferedReader reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes())));
        Baek1654 a = new Baek1654();
        Baek1654_refer b = new Baek1654_refer();

        long r1 = 0;
        long r2 = 0;
        while(r1 == r2) {
            StringBuilder sb = new StringBuilder();
        int n = random.nextInt(10)+1;
        int m = random.nextInt(100)+1;
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(Integer.MAX_VALUE-1)+1;
        }
        sb.append(n).append(" ").append(m).append("\n");
        for (int i : arr) {
            sb.append(i).append("\n");
        }

            r1 = a.getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));
            r2 = b.getResult(new BufferedReader(new InputStreamReader(new ByteArrayInputStream(sb.toString().getBytes()))));
            
            if(r1 != r2){
                System.out.println(r1);
                System.out.println(r2);
            System.out.println(sb.toString());
                break;
            }
        }
    }


    
}
