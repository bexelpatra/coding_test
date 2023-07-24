import java.util.ArrayList;
import java.util.List;

public class QueryParsing {
    public static void main(String[] args) {

        String query = "SELECT DATE_FORMAT(REGIST_DT, '%Y-%m-%d') as beginDate FROM TB_MRHST_MANAGE INNER JOIN ( SELECT DISTINCT(confm.CONFM_MANAGE_ID) as CONFM_MANAGE_ID FROM TB_CONFM_MANAGE confm INNER JOIN TB_MNGR_GROUP_MANAGE gp ON confm.MNGR_GROUP_ID = gp.MNGR_GROUP_ID WHERE confm.REGISTER_ID = ? OR gp.TELECOM_CODE = ? ) X ON MRHST_MANAGE_ID = X.CONFM_MANAGE_ID ORDER BY REGIST_DT ASC LIMIT 1 ";
        String rawParam = "a45hvn(String), 1002003,1002002,1002001(String)"
                .replaceAll(" ", "");
        List<String> list = new ArrayList<>();
        List<String> tList = new ArrayList<>();
        StringBuilder sb = null;
        StringBuilder type = null;
        int idx = 0;
        while (idx < rawParam.length()) {
            char now = rawParam.charAt(idx);
            if (now == ',') {
                idx += 1;
                continue;
            }
            sb = new StringBuilder();
            while (now != '(') {
                sb.append(now);
                idx += 1;
                now = rawParam.charAt(idx);
            }

            idx += 1;
            now = rawParam.charAt(idx);
            type = new StringBuilder();
            while (now != ')') {
                type.append(now);
                idx += 1;
                now = rawParam.charAt(idx);
            }
            if (type.toString().toLowerCase().equals("string")) {
                list.add("'" + sb.toString() + "'");
            } else {
                list.add(sb.toString());
            }
            idx += 1;
        }

        for (int i = 0; i < list.size(); i++) {
            query = query.replaceFirst("\\?", list.get(i));
        }
        System.out.println(query);
        // for (int i = 0; i < rawParam.length(); i++) {
        // char now = rawParam.charAt(i);
        // if(now == '('){

        // }else if(now == ')'){

        // }
        // }

    }
}
