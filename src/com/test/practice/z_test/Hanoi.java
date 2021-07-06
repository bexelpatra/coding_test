package com.test.practice.z_test;

public class Hanoi {
    public static int count = 0;
    public static void Hanoi(int N, int start, int mid, int to) {
        count++;
        System.out.println("hanoi : "+count);
        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            System.out.println(start + " " + to);
            return;
        }

        // STEP 1 : N-1개를 A에서 B로 이동
        Hanoi(N - 1, start, to, mid);

        // STEP 2 : 1개를 A에서 C로 이동
        System.out.println(start + " " + to);

        // STEP 3 : N-1개를 B에서 C로 이동
        Hanoi2(N - 1, mid, start, to);

    }
    public static void Hanoi2(int N, int start, int mid, int to) {
        count++;
        System.out.println("hanoi2 : "+count);
        // 이동할 원반의 수가 1개라면?
        if (N == 1) {
            System.out.println(start + " " + to);
            return;
        }

        // STEP 1 : N-1개를 A에서 B로 이동
        Hanoi(N - 1, start, to, mid);

        // STEP 2 : 1개를 A에서 C로 이동
        System.out.println(start + " " + to);

        // STEP 3 : N-1개를 B에서 C로 이동
        Hanoi(N - 1, mid, start, to);

    }

    public static void myHanoi(int n, int from, int mid, int to){
        if(n == 1){
            System.out.println(from+":"+to);
            return;
        }
        myHanoi(n-1,from,to,mid);
        System.out.println();
        myHanoi(n-1,mid,from,to);
    }
}
