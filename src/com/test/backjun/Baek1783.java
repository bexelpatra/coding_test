package com.test.backjun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek1783 {
    static int[] dx = new int[]{1,2,2,1};
    static int[] dy = new int[]{2,1,-1,-2};
    public static void main(String[] args) throws Exception{
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(reader.readLine());
        long y = Long.parseLong(st.nextToken());
        long x = Long.parseLong(st.nextToken());

//        long ans = recursive(x,y,1,1,0);
//        System.out.println(ans);
        if (y==1){
            System.out.println(1);
            return;
        }
        if(y==2){
            System.out.println(Math.min(4,(x+1)/2));
            return;
        }
        if(x<7){
            System.out.println(Math.min(4,x));
            return;
        }
        System.out.println(x-2);

    }
    public static long recursive(long x, long y, long nowX, long nowY,long count){
        if(nowX>x || nowY>y){
            return count;
        }
        if(nowX<0 || nowY<0){
            return count;
        }
        long answer = 0;
        count+=1;
        long check = 1;
        for (int i = 0; i < 4; i++) {
            long temp = recursive(x,y,nowX+dx[i],nowY+dy[i],count);
            check*=temp;
            answer += temp;
        }
        if (check>1){

        }
        return answer;
    }
}
