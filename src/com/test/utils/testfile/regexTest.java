package com.test.utils.testfile;

public class regexTest {
    public static void main(String[] args) {
        String cdata = "select merc_gds_seq , lnup_seq , merc_id , gds_nm , gds_stcd , (select cd_nm from tb_com_cd_dtl where cd_dvcd = '1042' and cd = tba.gds_stcd and rownum <![cdata[<=]]> 1 ) as gds_stnm , nvl(tba.img_no, '') as img_no , #{imgurl} || img_no as img_url , prc , to_char(to_date(gds_sel_end_dt, \r\n" + //
                "'yyyymmdd'), 'yyyy.mm.dd') as gds_sle_endt  , to_char(last_chng_dttm, 'yyyy.mm.dd hh24:mi:ss') as gds_sle_spnd_dttm  , to_char(nvl(tba.gds_sle_bltn_dttm, tba.last_chng_dttm), 'yyyy.mm.dd') as gds_sle_bltn_dttm  '?\uB64B\uF9CD\u317C\uC94C\u7337?' ?\uC52A?\uBE23 ?\uB64B\uF9CD? \u4EE5\uBB12??\uC52A?\uB586, ?\uBE18?\uB572\uF9CE? \uF9CD\uB349?\uF9CD? ?\uB2D4?\uC819?\uC52A  , case when gds_stcd = '01' then to_char(nvl(tba.gds_sle_spnd_dttm, tba.last_chng_dttm), 'yyyy.mm.dd hh24:mi:ss') else '' end as gds_sle_spnd_dttm , case when gds_stcd = '01' then to_char(nvl(tba.gds_sle_spnd_dttm, tba.last_chng_dttm), 'yyyy.mm.dd') else '' end as gds_sle_spnd_dt , case when \r\n" + //
                "(gds_sel_end_dt <![cdata[<]]> to_char(sysdate, 'yyyymmdd')) then 'n' else 'y' end sel_end_dt_vld_yn from tb_merc_gds tba where merc_gds_seq = #{mercgdsseq}";
        String result = removeData(cdata,"<![cdata[","]]>",true);
        result = removeData(result,"<!--","-->", false);
        System.out.println(result);
    }

    public static String removeData(String cdata,String startPattern,String endPattern ,boolean flag){
        StringBuffer sb = new StringBuffer();
        int s = cdata.indexOf(startPattern);
        int e = cdata.indexOf(endPattern,s);
        int begin = 0;

        while(s >-1){
            System.out.println(s);
            System.out.println(e);
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
