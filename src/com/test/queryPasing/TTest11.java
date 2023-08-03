package com.test.queryPasing;

import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.time.ZonedDateTime;
import java.util.Random;

public class TTest11 {
    public static void main(String[] args) throws Exception{
        String q = null;
        StringBuffer buffer = new StringBuffer();
        Random random = new Random(ZonedDateTime.now().getNano());
        for (int i = 0; i < 100; i++) {
            random.longs(100, 'a', 'z').mapToObj(operand ->{
                return (char)operand;
            } ).forEach(t -> buffer.append(t));
        }
        q=buffer.toString();
        String target= args[0];
        q= q.replaceAll(target, String.format("\033[33m%s\033[0m",target ));
        String form = String.format("\033[33m%s\033[0m", "my message");

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        writer.write(q);

        writer.flush();
        writer.close();

    }
}
