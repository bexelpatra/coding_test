package com.test.ETC;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

public class RunTest {
    public static void main(String[] args) {
        Runtime rt = Runtime.getRuntime();
        Process p = null;
        String path = "java connTest";
        String[] arr = "java,-cp '/home/ec2-user/',connTest".split(",");
        BufferedReader reader = null;
        InputStream is = null;

        System.out.println("start!");
        try {
            p = rt.exec(arr);

            p.waitFor(3, TimeUnit.SECONDS);
            System.out.println("process done");
            is = p.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is));
            String line = "";
            System.out.println("read start");
            while ((line = reader.readLine()) != null) {
                System.out.println("runtime test : " + line);
            }

            p.destroy();
            System.out.println("read end");
            is.close();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("simai");
    }
}
