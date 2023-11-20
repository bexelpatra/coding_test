package com.test.TEST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TTest11 {
    public static void main(String[] args) {
        List<Byte> list = Stream.generate(() -> (byte)(Math.random()*1000)).limit(100).collect(Collectors.toList());
        for (Byte byte1 : list) {
            System.out.printf("%c, %d\n",byte1 & 0xff,(byte1));
        }
        System.out.println((char)0xff);

        System.out.println();

        long pow = (long)Math.pow(4, 3);
        System.out.println(pow);
        int[] arrayList = IntStream.generate(() -> {return 0;}).limit(3).toArray();
        for (int i = 0; i < pow; i++) {
            
            System.out.println(String.format("%03d %d %d",Integer.parseInt(Integer.toString(i, 4)),i/4, i%4) );
        }

        int x = 132154;
        StringBuilder sb = new StringBuilder();
        while(x >0){
            sb.append(x%10).append(" ");
            x/=10;
        }
        System.out.println(sb.toString());
        
        
    }
}
