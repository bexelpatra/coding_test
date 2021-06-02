import com.test.practice.c_heap.Heap_1;
import com.test.practice.c_heap.Heap_2;
import com.test.practice.c_heap.Heap_3;
import com.test.practice.d_sort.QuickSorter;
import com.test.practice.d_sort.Sort_1;
import com.test.practice.d_sort.Sort_2;
import com.test.practice.d_sort.Sort_3;

import java.util.*;
import java.util.stream.IntStream;

public class CodingTest {
    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 3, 9, 10, 12};
//        int[] p = new int[]{11, 13, 14, 13, 1, 3};
//        int[] p = new int[]{1, 1, 9, 1, 1, 1};
//        int[] s = new int[]{1, 1, 1, 1, 1, 1};
//        String[] pp =  new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
//        String[] ppp =  new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
//        int[][] ints = new int[][]{{0,3},{1,9},{2,7},{30,5}};
        int[][] ints = new int[][]{{2,5,3},{4,10},{15,2},{5,11}};
//        new Sort_1().solution(p,ints);
        Random random = new Random();
//        new Sort_1().solution2(IntStream.generate(() -> random.nextInt(20)).limit(10).toArray(),new int[][]{{2,6,4}});
        int a[]=new int[]{10,11} ;
        QuickSorter.quickSort(new int[]{3,4,9,5,6});

        System.out.println(new Sort_3().solution(new int[]{0,1,2}));
    }
}
