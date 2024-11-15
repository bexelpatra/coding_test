package com.test.ETC;

import java.io.File;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract1;
import net.sourceforge.tess4j.TesseractException;


public class Tess {
    
    public static void main(String[] args) {
        long time = System.currentTimeMillis();
        System.setProperty("jna.library.path", "D:/tessdata-main");
        ITesseract tesseract = new Tesseract1();
        String path = "d:/temp.pdf";
        File file = new File(path);
        // File tessDataFolder = LoadLibs.extractNativeResources("tessdata");
        // System.out.println(tessDataFolder.toString());
        tesseract.setDatapath("d:/tessdata-main");
        

        String result ="";
        try {
            result = tesseract.doOCR(file);
        } catch (TesseractException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(result);
        long timeSpent = System.currentTimeMillis() - time;
        System.out.println(1000/100%50);
        // System.out.printf("end ==> %02d:%02d:%02d \n",timeSpent/1000/3600,timeSpent/1000/60);
    }
}
