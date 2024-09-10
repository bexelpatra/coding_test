package codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Teest1 {
    public static void main(String[] args) {
        int[] arr = new int[]{4,1,3,5,4,3,2,1};
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            list.add(a);
        }
        int[] result = new int[arr.length];
        int val = 1;
        result[0] = val;
        for (int i = 0; i < list.size()-1; i++) {
            int now = list.get(i);
            int next = list.get(i+1);
            if(now < next){
                result[i+1] = val++;
            }else if(now == next){
                val = result[now] == 1 ? 2:1;
                result[next] = val;
            }else{
                int count = 1;
                int j = i+1;
                while(j++ < list.size()-1 && next > list.get(j)){
                    count++;
                }

                // System.out.println(i+""+count);
                
            }
        }
        candies(7, arr);
    }
    static long candies(int n, int[] arr) {
        long sum = 0;
        int[] dp_up = new int[arr.length];
        int[] dp_down = new int[arr.length];
        dp_up[0] = 1;
        dp_down[arr.length-1] = 1;
        
        for(int i=1; i<arr.length; i++){
            dp_up[i] = (arr[i-1] < arr[i]) ? (dp_up[i-1] + 1) : 1;
        }

        for(int i=arr.length-2; i>=0; i--){
            dp_down[i] = (arr[i+1] < arr[i]) ? (dp_down[i+1] + 1) : 1;
        }
        System.out.println(Arrays.toString(dp_up));
        System.out.println(Arrays.toString(dp_down));
        for(int i=0; i<arr.length; i++) {
        	sum += Math.max(dp_up[i], dp_down[i]);
        }
        
        return sum;
    }
}
