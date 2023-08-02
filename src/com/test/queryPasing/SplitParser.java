package com.test.queryPasing;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SplitParser {
    public static void main(String[] args) {
        String regex = "[\\da-z]+";
        String q = "select a as a, b ,c ,     ( select d from table1 ) from table2 t where asdf = '2322' ".toLowerCase();
        String[] qs = q.split(" ");
        Stack<SelectDTO> list = new Stack<>();
        SelectDTO now = null;
        for (int i = 0; i < qs.length; i++) {
            String s = qs[i];
            if("".equals(s)|| " ".equals(s)){
                continue;
            }
            // System.out.println(s);
            if("select".equals(s)){
                now = new SelectDTO();
                list.add(now);
                // int temp = i;
                // while(!qs[temp++].equals("from")){
                //     now = new SelectDTO();
                //     list.add(now);
                // }
            }else if("from".equals(s)){
                // 다음에 올 수 있는건 ? 
                /*
                 * 1. alias
                 *  1-1 join -> self, inner left/outer join
                 *  1-2 where, order by , group by
                 * 2. (sub query)
                 *  2-1 무조건 (
                 */
                now.setTableName(qs[i+1]);
            }else if("where".equals(s)){
                //where 다음에 뭐가 오는지 중요

            }else if("order".equals(s)){
                
            }else if("group".equals(s)){
                
            }else if("join".equals(s)){
                
            }
            if(s.startsWith(",")){
                System.out.println(s);
            }else if(s.startsWith("(")){
                System.out.println(s);
            }else if(s.endsWith(",")){
                System.out.println(s);
            }
        }


        for (SelectDTO selectDTO : list) {
            System.out.println(selectDTO.toString());
        }
        // String a = "(abc, '1";
        // System.out.println(a.replaceAll(regex, ""));
    }
    public static int findIndex(String[] args,int i,String keyword){
        for (int j = i; j < args.length; j++) {
            if(args[j].equals(keyword)){
                return j;
            }
        }
        return -1;
    }
}
