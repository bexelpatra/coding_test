package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10775 {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        greedy(reader);
        unionFind(reader);

//        int[] test = new int[6];
//        for (int i = 1; i < 6; i++) {
//            test[i] = i;
//        }
//        union(5,4,test);
//        union(4,3,test);
//        System.out.println(find(4,test));
//        System.out.println();

    }

    private static void unionFind(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int plane = Integer.parseInt(reader.readLine());
        int[] parent = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            parent[i] = i;
        }

        int ans = 0;
        for (int i = 0; i < plane; i++) {
            int now = Integer.parseInt(reader.readLine());
//            if(now>n) break;
            int pk = find(now,parent);
            if(pk!=0) {
                union(pk,pk-1,parent);
                ans+=1;
            }else{
                break;
            }

        }
        System.out.println(ans);
    }

    //https://escapefromcoding.tistory.com/208
    private static void greedy(BufferedReader reader) throws IOException {
        int n = Integer.parseInt(reader.readLine());
        int plane = Integer.parseInt(reader.readLine());
        boolean[] parking = new boolean[100001];

        int ans = 0;

        boolean stop = true;
        for (int i = 0; i < plane; i++) {
            int now = Integer.parseInt(reader.readLine());
            if(now >n){
                break;
            }
            stop = true;
            for (int j = now; j >=1 ; j--) {
                if(!parking[j]){
                    parking[j] = true;
                    stop = false;
                    ans+=1;
                    break;
                }
            }
            if (stop){
                System.out.println(ans);
                return;
            }
        }
        System.out.println(ans);
    }

    public static int find(int now, int[] parent) {
        if(now == parent[now])
            return now;
        return parent[now] = find(parent[now],parent);
    }
    public static void union(int x, int y,int[] parent) {
        x = find(x,parent);
        y = find(y,parent);

        if(x != y) {
            parent[x] = y;
        }
    }
}
