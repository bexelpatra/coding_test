package com.test.TEST;

import java.io.IOException;
import java.io.StringReader;
import java.util.Properties;
import java.util.regex.Pattern;

public class TTest20 {
    public static void main(String[] args) throws IOException {
        String a = "";
        String[] b = new String[2];

        System.out.println(a.getClass().getSimpleName());
        System.out.println(b.getClass().getSimpleName());
        
        // System.out.println(Pattern.matches("0000|0009", null));

        Properties prop = new Properties();
        prop.load(new StringReader("rmnlOsCode=1011002, svcId=0f8b720acbc849759fcfd532668205cc0c6126ac7dc2723958655a17d1833f1d, reissuNo=0, drvLcnsNo=111981715470, esntlIdntfcNoAgreAt=Y, ci=YZcvIdTenyY/biOGW5USz6t9y6haDcGs2h1+yJbeKIi9LiW3LS0gpDHwSiR5e+hZAqClET9fj60CneqUvMDXuQ==, trmnlModelNm=?unrecognized?, telecomCode=1002003, indvdlinfoColctUseAgreAt=Y, trmnlOsVer=17.2.1, agreJobCnsgnAgreAt=Y, mobileSdkVer=2.0.7, pgeNo=0, pgeSize=30, registerId=0f8b720acbc849759fcfd532668205cc0c6126ac7dc2723958655a17d1833f1d, registProgrmId=1010002, updusrId=0f8b720acbc849759fcfd532668205cc0c6126ac7dc2723958655a17d1833f1d, updtProgrmId=1010002, requestUri=/api/mobilelcnse/mlif/manage/reqPoliceMobileDrvLcnseRgist".replace(", ", "\n")));

        prop.entrySet().forEach(t -> System.out.println(t.getKey() + " : " + t.getValue()));
        
    }
}
