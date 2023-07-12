package com.test.queryPasing;

public class TuningUtils {
    public static String removeData(String cdata,String startPattern,String endPattern ,boolean flag){
        StringBuffer sb = new StringBuffer();
        int s = cdata.indexOf(startPattern);
        int e = cdata.indexOf(endPattern,s);
        int begin = 0;

        while(s >-1){
            sb.append(cdata.substring(begin, s));
            if(flag){
                sb.append(cdata.substring(s + startPattern.length(), e)); 
            }
            s = cdata.indexOf(startPattern,s+1);
            begin = e+endPattern.length();
            e = cdata.indexOf(endPattern,s+1);
        }
        sb.append(cdata.substring(begin, cdata.length()));
        return sb.toString();
    }
}
