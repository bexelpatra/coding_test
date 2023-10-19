package com.test.TEST;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TTest11 {
    public static void main(String[] args) {
        List<Byte> list = Stream.generate(() -> (byte)(Math.random()*1000)).limit(100).collect(Collectors.toList());
        for (Byte byte1 : list) {
            System.out.printf("%c, %d\n",byte1 & 0xff,(byte1));
        }
        System.out.println((char)0xff);
        
    }
}
