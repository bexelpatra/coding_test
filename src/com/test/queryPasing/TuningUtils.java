package com.test.queryPasing;

public class TuningUtils {
    public static String removeData(String cdata, String startPattern, String endPattern, boolean flag) {
        StringBuffer sb = new StringBuffer();
        int s = cdata.indexOf(startPattern);
        int e = cdata.indexOf(endPattern, s);
        int begin = 0;

        while (s > -1) {
            sb.append(cdata.substring(begin, s));
            if (flag) {
                sb.append(cdata.substring(s + startPattern.length(), e));
            }
            s = cdata.indexOf(startPattern, s + 1);
            begin = e + endPattern.length();
            e = cdata.indexOf(endPattern, s + 1);
        }
        sb.append(cdata.substring(begin, cdata.length()));
        return sb.toString();
    }

    public static void main(String[] args) {
        String x = "select count(*) as listco from tb_vrsccmpny_manage b where 1=1 and b.approval_telecom regexp replace(#{telecomcode},',','|') and b.vrsccmpny_sttus_code in('1016003', '1016006') and date_format(b.updt_dt, '%y%m%d') = #{requstde} <!-- select count(*) as listco from tb_vrsccmpny_manage where date_format(updt_dt, '%y%m%d') = #{requstde} --> <!-- select count(*) as listco from tb_confm_manage a inner join tb_vrsccmpny_manage b on a.confm_manage_id = b.vrsccmpny_manage_id inner join tb_mngr_group_manage c on a.mngr_group_id = c.mngr_group_id and c.telecom_code regexp replace(#{telecomcode},',','|') where b.vrsccmpny_sttus_code in('1016003', '1016006') -->";
        String temp = removeData(x, "<!--", "-->", false);
        System.out.println(x);
        System.out.println(temp);
    }
}
