package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// 실패...
// 플로이드 와샬로 파티 참여자를 연결하려고 했지만 안된다.
// 유니온 파인드
public class Baek1043_retry {
    public static void main(String[] args) throws IOException {
        // getCount();
        getCount3();
    }
    // 일단 합집합 구한다음 진실을 아는 그룹인지 확인하려고 했는데 마음같지 않네...
    private static void getCount3() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        people = new int[n+1];
        for (int i = 0; i < people.length; i++) {
            people[i] = i;
        }
        st = new StringTokenizer(reader.readLine());

        int knowCount = Integer.parseInt(st.nextToken());
        List<Integer> truths = new ArrayList<>();
        boolean[] know = new boolean[n+1];
        for (int i = 0; i < knowCount; i++) {
            int temp = Integer.parseInt(st.nextToken()); 
            truths.add(temp);
            know[temp] = true;
        }
        
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] party = new int[len];
            int x = Integer.parseInt(st.nextToken());
            party[0] = x;

            for (int j = 1; j < len; j++) {
                int y = Integer.parseInt(st.nextToken());

                union2(x, y);
                party[j] =y;
            }
            parties.add(party);
        }
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if(know[i] && !visited[i]){
                int root = find(i);
                for (int j = 1; j <= n; j++){
                    if (find(j)==root) {
                        know[j] = true;
                        visited[j] = true;
                    }
                }
            }
        }
        int count =0 ;
        for (int i = 0; i < parties.size(); i++) {
            boolean flag = false;
            for (int is : parties.get(i)) {
                if(know[is]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                count+=1;
            }
        }
        System.out.println(m-count);
    }

    // 메모리 초과가 나온다.
    private static void getCount2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        people = new int[n+1];
        for (int i = 0; i < people.length; i++) {
            people[i] = i;
        }
        st = new StringTokenizer(reader.readLine());

        int knowCount = Integer.parseInt(st.nextToken());
        List<Integer> truths = new ArrayList<>();
        boolean[] know = new boolean[n+1];
        for (int i = 0; i < knowCount; i++) {
            int temp = Integer.parseInt(st.nextToken()); 
            truths.add(temp);
            know[temp] = true;
        }
        
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] party = new int[len];
            int x = Integer.parseInt(st.nextToken());
            party[0] = x;

            for (int j = 1; j < len; j++) {
                int y = Integer.parseInt(st.nextToken());

                union2(x, y);
                party[j] =y;
            }
            parties.add(party);
        }
        for (int i = 1; i < people.length; i++) {
            change(i, know, new boolean[know.length]);
        }
        int count =0 ;
        for (int i = 0; i < parties.size(); i++) {
            boolean flag = false;
            for (int is : parties.get(i)) {
                if(know[is]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                count+=1;
            }
        }
        System.out.println(m-count);
    }
    // union 하면서 진실을 아는지 체크한다.
    private static void getCount() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        people = new int[n+1];
        for (int i = 0; i < people.length; i++) {
            people[i] = i;
        }
        st = new StringTokenizer(reader.readLine());

        int knowCount = Integer.parseInt(st.nextToken());
        List<Integer> truths = new ArrayList<>();

        for (int i = 0; i < knowCount; i++) {
            truths.add(Integer.parseInt(st.nextToken()));
        }
        
        List<int[]> parties = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            int len = Integer.parseInt(st.nextToken());
            int[] party = new int[len];
            int x = Integer.parseInt(st.nextToken());
            party[0] = x;

            for (int j = 1; j < len; j++) {
                int y = Integer.parseInt(st.nextToken());

                union(x, y,truths);
                party[j] =y;
            }
            parties.add(party);
        }

        int count =0 ;
        for (int i = 0; i < parties.size(); i++) {
            boolean flag = false;
            for (int is : parties.get(i)) {
                if(truths.contains(find(is))){
                    flag = true;
                    break;
                }
            }
            if(flag){
                count+=1;
            }
        }
        System.out.println(m-count);
    }
    static int[] people;
    public static void union(int x, int y,List<Integer> truths){
        // people[find(y)] = x;
        int rootX = find(x);
        int rootY = find(y);
        if(truths.contains(rootY)){
            int tmp = rootX;
            rootX = rootY;
            rootY = tmp;
        }
        people[rootY] = rootX;
        
    }
    public static void union2(int x, int y){
        people[find(y)]=x;
    }
    public static int find(int x){
        if(people[x] ==x){
            return people[x];
        }
        return find(people[x]);
    }
    // 1이 진실을 알고 4에 1이 통합되면 찾지 못한다.
    public static boolean check(int x,boolean[] know,boolean flag){
        if(!flag){
            flag = know[x];
        }
        if(people[x]==x){
            return flag;
        }

        return check(people[x],know, flag);
    }

    public static void change(int x,boolean[] know,boolean[] visited){
        if(know[x] && !visited[x]){
            know[find(x)]=true;
            visited[x]= true;
        }
    }
}
