import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.test.practice.e_exhaustive_search.Permutations;

public class SimpleTest {

	public static void main(String[] args) {
//		test1();
		List<String> arr = new ArrayList<>();
		arr.add("a");
		arr.add("b");
		arr.add("c");
		arr.add("d");
		List<String> result = new ArrayList<>();
//		Permutations.combination(arr, result, 0, 4, 2  );
//		Permutations.perm2(arr, result, 4, 2 );
		
//		Permutations.perm(new int[] {1,2,3,4}, 0, 4, 3);
//		DIYPerm(new int[] {1,2,3,4}, 0, 4, 2);
		int[] arr2 = new int[5];
		combination(arr2, 0, 5, 3, 0);
	}
	
	// combi test
	private static void test1() {
		int n =6;
		boolean[] used = new boolean[n];
		combiTest1(0,used,0,n);
	}
	public static void combiTest1(int idx, boolean[] used, int count,int total) {
		if(count == total/2) {
			int num;
			for (boolean b : used) {
				System.out.print((num = b?0:1) + " ");
			}
			System.out.println();
		}
		for (int i = idx; i < total; i++) {
			if(!used[i]) {
				used[i] = true;
				combiTest1(i+1,used,count+1,total);
				used[i] = false;
			}
		}
	}
	
	// 자리바꿈을 통해 순열 생성
	public static void DIYPerm(int[] arr, int depth, int n, int r) {
		if(depth == r) {
			for (int i = 0; i < r; i++) {
				System.out.printf("%d ",arr[i]);
			}
			System.out.println();
			return;
		}
		int temp = 0;
		for (int i = depth; i < arr.length; i++) {
			temp = arr[i];
			arr[i] = arr[depth];
			arr[depth] = temp;
			DIYPerm(arr, depth+1, n, r);
			temp = arr[i];
			arr[i] = arr[depth];
			arr[depth] = temp;
		}
	}
	
	// 점화식을 이용한 재귀함수 활용
	public static void combination(int[] arr, int index, int n, int r, int target) {
		System.out.println(Arrays.toString(arr));
		System.out.println(index);
		System.out.println(n +" "+ r);
		System.out.println(target);
		if      (r == 0) print(arr, index);
		else if (target == n) return;
		else {
			arr[index] = target;
			combination(arr, index + 1, n, r - 1, target + 1);
			combination(arr, index, n, r, target + 1);
		}
	}//end combination()
	
	public static void print(int[] arr, int length) {
		System.out.println("---------");
		for (int i = 0; i < length; i++) System.out.print(arr[i]);
		System.out.println();
		System.out.println("---------");
	}
	
}
