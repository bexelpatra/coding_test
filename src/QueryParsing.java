import java.util.ArrayList;
import java.util.List;

public class QueryParsing {
    public static void main(String[] args) {

        String query = "";
        String rawParam = ""
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
