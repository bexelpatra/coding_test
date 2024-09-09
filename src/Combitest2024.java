import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class Combitest2024 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        int[] result= new int[2];
        combi(arr, result, 0, 0);
        ZonedDateTime now = ZonedDateTime.of(2016, 1, 1, 0, 0, 0, 0, ZoneId.systemDefault());
        now = now.plus(255,ChronoUnit.DAYS );
        System.out.println(now.toString());

        
        
    }
    public static void combi(int[] arr,int[] result,int start,int i){
        if(i == result.length){
            System.out.println(Arrays.toString(result));
            return;
        }
        for (int j = 0; j < arr.length; j++) {
            result[i] = arr[j];
            combi(arr, result, j+1, i+1);
        }
    }
}
