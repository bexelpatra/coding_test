package com.test.TEST;

public class TTest22 {

    public static void main(String[] args) {
        String temp = "@123";
        String newone = "";

        newone = temp.replace("@123", "006");
        System.out.println(temp);
        System.err.println(newone);

        
        int[] arr = new int[]{2,3,1,3,5,4,3,2,1};
        long sum = 0;
        int high = 1;
        int val = 1;
        System.out.printf("%d ",val);
        for (int i = 0; i < arr.length-1; i++) {
            int now = arr[i];
            int next = arr[i+1];
            if(now <next){
                sum+=val++;
            }else {
                int count = 0;
                while( ++i <arr.length && arr[i-1] > arr[i] ){
                  count+=1;
                }
                System.out.println("count  : "+count);
            }
            System.out.printf("%d ",val);
        }
        
        
    }
}
