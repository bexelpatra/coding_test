package com.test.utils.testfile;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Base64;

import javax.imageio.ImageIO;
// import javax.xml.bind.DatatypeConverter;

public class Base64Img {
    public static void main(String[] args) throws IOException {
        String b = "d://eye.txt";

        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(b))));
        StringBuilder sb = new StringBuilder();
        char[] buf = new char[1024];
        int n = 0;
        while ((n = reader.read(buf, 0, buf.length)) > 0) {
            sb.append(buf, 0, n);
        }
        System.out.println(decoder(sb.toString(), "d:/test/im.jpg"));
        reader.close();
    }

    public static boolean decoder(String base64, String target) {
        
        // byte[] imageBytes = DatatypeConverter.parseBase64Binary(base64);
        byte[] imageBytes = Base64.getDecoder().decode(base64.getBytes());
        try {
            BufferedImage bufImg = ImageIO.read(new ByteArrayInputStream(imageBytes));

            ImageIO.write(bufImg, "jpg", new File(target));

        } catch (IOException e) {
            e.printStackTrace();

            return false;
        }

        return true;

    }
}
