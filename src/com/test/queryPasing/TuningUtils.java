package com.test.queryPasing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
    // 시운전 준비중...
    public static String skipStr(String line,char open ,char close){
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        Stack<StringBuilder> stack = new Stack<>();
        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);
            if(now==open){
                StringBuilder innerSb = new StringBuilder();
                stack.add(innerSb);
            }else if(now==close){

            }
            
            sb.append(now);
        }
        return sb.toString();
    }
    public static String skipStr(String line){
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < line.length(); i++) {
            char now = line.charAt(i);
            if(now == '\'' || now =='\"'){
                flag = !flag;
                sb.append(now);
                continue;
            }
            if(flag){
                 now = '@';
            }
            sb.append(now);
        }
        return sb.toString();
    }
    public static List<Integer> keywords(String line, String key){
        line = skipStr(line);
        int k = 0;
		List<Integer> list =  new ArrayList<>();
		int idx = 0;
		while((k = line.indexOf(key,idx))>-1){
			list.add(k);
			idx = k+1;
		}
        return list;
    }
    public static List<int[]> makeOpenCloseSet(List<Integer> start,List<Integer> end){
        List<int[]> result = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        pq.addAll(start.stream().map(t ->new int[]{t,0}).collect(Collectors.toList()));
        pq.addAll(end.stream().map(t ->new int[]{t,1}).collect(Collectors.toList()));
        Stack<int[]> stack = new Stack<>();
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[0]==77){
                System.out.println("");
            }
            if(now[1]==0){
                stack.add(new int[]{now[0],0});
            }else{
                int[] complete = stack.pop();
                complete[1] = now[0];
                result.add(complete);
            }
        }
        while(!stack.empty()){
            result.add(stack.pop());
        }

        return result;
    }

    public static List<int[]> makeOpenCloseSet(List<Integer> ...keywords){
        List<int[]> result = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0]-o2[0]);
        Queue<Integer> q = new LinkedList<>();
        int keywordsLen = keywords.length;
        for (int i = 0; i < keywordsLen; i++) {
            int len = keywords[i].size();
            for (int j = 0; j < len; j++) {
                q.add(i);
            }
        }
        for (List<Integer> s : keywords) {
            pq.addAll(s.stream().map(t ->new int[]{t,q.poll()}).collect(Collectors.toList()));
        }
        Stack<int[]> stack = new Stack<>();
        
        
        int last = 0;
        while(!pq.isEmpty()){
            int[] now = pq.poll();
            if(now[1]==0){
                int[] temp = new int[keywordsLen];
                temp[0] = now[now[1]];
                stack.add(temp);
                last = now[1];
            }else if(now[1]>last){
                int[] pop = stack.pop();
                pop[now[1]] = now[0];
                stack.add(pop);
                last = now[1];
            }else if(now[1]<=last){
                int[] pop = stack.pop();
                result.add(pop);
                pop = stack.pop();
                pop[now[1]] = now[0];
                stack.add(pop);
                last = now[1];
            }else{
                System.out.println("########################################");
            }
        }
        while(!stack.empty()){
            result.add(stack.pop());
        }

        return result;
    }    

    private static int[] extracted(int idx, Integer t) {
        return new int[]{t,idx++};
    }

    public static String[] columnParse(String line){
        String beforeSplit = skipStr(line);
        // List<Integer> comma = keywords(beforeSplit, ",");
        System.out.println(beforeSplit);
        return null;
    }
    public static String[] afterFromParse(String line){
        String beforeSplit = skipStr(line);
        // List<Integer> comma = keywords(beforeSplit, ",");
        System.out.println(beforeSplit);
        return null;
    }
    public static void main(String[] args) {
        // String x = "select count(*) as listco from tb_vrsccmpny_manage b where 1=1 and b.approval_telecom regexp replace(#{telecomcode},',','|') and b.vrsccmpny_sttus_code in('1016003', '1016006') and date_format(b.updt_dt, '%y%m%d') = #{requstde} <!-- select count(*) as listco from tb_vrsccmpny_manage where date_format(updt_dt, '%y%m%d') = #{requstde} --> <!-- select count(*) as listco from tb_confm_manage a inner join tb_vrsccmpny_manage b on a.confm_manage_id = b.vrsccmpny_manage_id inner join tb_mngr_group_manage c on a.mngr_group_id = c.mngr_group_id and c.telecom_code regexp replace(#{telecomcode},',','|') where b.vrsccmpny_sttus_code in('1016003', '1016006') -->";
        // x = removeData(x, "<!--", "-->", false);
        // System.out.println(x);
        // System.out.println();

        String a = "select a from b where c = (select c from tb where 1=1)";
        String b = a.replaceAll("select[^(]+from", " ");

        System.out.println(b);
        

    }
}
