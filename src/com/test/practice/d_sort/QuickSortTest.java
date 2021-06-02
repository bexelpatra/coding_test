package com.test.practice.d_sort;

public class QuickSortTest {
    public static void q_sort(int[] arr){

    }

    private void sort(int[] arr,int small,int big){
        if(small>=big){
            return;
        }

        int pivot = arr[(small+big)/2];
        while(small<=big){
            while(arr[small]<pivot) small++;
            while(arr[big]>pivot) big++;
            if(small<=big){
                swap(arr,small,big);
                small++;
                big--;
            }
        }

//        sort(arr,);
    }

    private void swap(int[] arr,int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
