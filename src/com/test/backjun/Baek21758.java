package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.stream.IntStream;

public class Baek21758 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        try {
            long a = 0;
            long b = 0;
            String temp = "";
            while(a==b){
                int n = (int)(Math.random()*5+3);
                StringBuilder sb = new StringBuilder();
                sb.append(n).append(System.lineSeparator());
                IntStream.generate(() -> (int)(Math.random()*10+1)).limit(n).forEach(value ->{sb.append(value).append(" ");} );

                a =getMidMax(sb.toString()) ;
                b=new Baek21758_refer().test(sb.toString());
                temp =sb.toString();
            }
            System.out.println(a);
            System.out.println(b);
            System.out.println(temp);
            ;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        };
    }

    private static long getMidMax(String arg) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // if(arg!=null){
        //     reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(arg.getBytes())));
        // }
        int n = Integer.parseInt(reader.readLine());
        long[] arr = new long[n];
        StringTokenizer st= new StringTokenizer(reader.readLine());
        long total = 0;        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            total += arr[i];
        }

        // left 왼쪽벌, 오른쪽 벌통
        long max = 0;
        long left = total - arr[0];
        long leftb = 0;
        long leftminus =arr[0];
        for (int i = 1; i < arr.length-1; i++) {
            leftb = total - arr[i]*2 - leftminus;
            leftminus+= arr[i];
            max = Math.max(max, leftb + left);
        }
        System.out.printf("left : %d\n",max);

        // right
        long right = total - arr[arr.length-1];
        long rightb =0 ;
        long rightminus = arr[arr.length-1];
        for (int i = arr.length-2; i >=1; i--) {
            rightb = total - arr[i]*2 - rightminus;
            rightminus+= arr[i];
            max = Math.max(max, rightb+right);
        }
        System.out.printf("right : %d\n",max);
        
        // mid
        long mid = total - arr[0] - arr[arr.length-1];
        long midMax = 0;
        for (int i = 1; i < arr.length-1; i++) {
            midMax = Math.max(midMax, arr[i]);
        }
        mid+= midMax;
        // System.out.println(mid);

        max = Math.max(max, mid);
        // System.out.println(max);
        return max;
    }
}
