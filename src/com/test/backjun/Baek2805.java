package com.test.backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// fail
public class Baek2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];
        st = new StringTokenizer(reader.readLine());
        
        for (int i = 0; i < trees.length; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            
        }
        Arrays.sort(trees);
        int idx = trees.length-1;
        
        int max = trees[idx];
        int myTree = 0;
        int count = 1 ;

        while(myTree<m){
            if(idx -1 >= 0){
                int nextTree = trees[idx] - trees[idx-1];
                myTree+= nextTree * count;

                idx -=1;
                count+=1;
            }else{
                break;
            }
        }

        int sum = 0;
        int i = 0 ;
        System.out.println(count);
        System.out.println(n - idx - 1);
        while(Math.abs(myTree - m) > (sum+i) * (n-idx -1) ) {
            i+=1;
        }
        
        System.out.println(trees[idx]+i);

       
    }

}
