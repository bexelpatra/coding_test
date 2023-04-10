import java.util.ArrayList;
import java.util.List;

import com.test.practice.e_exhaustive_search.Permutations;

public class SimpleTest {

	public static void main(String[] args) {
//		test1();
		List<String> arr = new ArrayList<>();
		List<String> result = new ArrayList<>();
		Permutations.combination(arr, result, 0, 0, 0);
		
	}
	
	// combi test
	private static void test1() {
		int n =6;
		boolean[] used = new boolean[n];
		combi(0,used,0,n);
	}
	public static void combi(int idx, boolean[] used, int count,int total) {
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
				combi(i+1,used,count+1,total);
				used[i] = false;
			}
		}
	}
	
}
