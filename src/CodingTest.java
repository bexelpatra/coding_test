import com.test.practice.c_heap.Heap_1;
import com.test.practice.c_heap.Heap_3;

import java.util.*;

public class CodingTest {
    public static void main(String[] args) {
        int[] p = new int[]{1, 2, 3, 9, 10, 12};
//        int[] p = new int[]{11, 13, 14, 13, 1, 3};
//        int[] p = new int[]{1, 1, 9, 1, 1, 1};
//        int[] s = new int[]{1, 1, 1, 1, 1, 1};
        String[] pp =  new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        String[] ppp =  new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int loca = 0;
//        new StackQueue_4().solution1(p);
        System.out.println(new Heap_3().solution(pp));
    }

    private static void m1() {
        int[] p = new int[]{11,1, 13, 14, 13, 1, 3};
        List<Integer> integerList = new ArrayList<>();
        for (int i : p) {
            integerList.add(i);
        }
        Collections.sort(integerList,(o1, o2) -> {
            if(String.valueOf(o1).length() == String.valueOf(o2).length()){
                return o1 - o2;
            }else {
                return o2 - o1;
            }
        });
        integerList.stream().forEach(integer -> System.out.println(integer));
    }
}
