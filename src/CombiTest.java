import java.util.Arrays;

public class CombiTest {

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 3, 4, 5 };
		combi1(arr, new int[3], 0, 0);
		System.out.println("============================================================");

		// perm1(arr, new int[3], 0, 0);
		perm2(arr, new int[3], new boolean[arr.length], 0);

	}

	// 조합
	public static void combi1(int[] arr, int[] result, int index, int count) {
		if (result.length == index) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			if (index > 0) {
				if (result[index - 1] >= arr[i])
					continue;
			}
			result[index] = arr[i];
			combi1(arr, result, index + 1, count + 1);
		}
	}

	// 순열
	public static void perm1(int[] arr, int[] result, int index, int count) {
		if (result.length == count) {
			for (int i = 0; i < result.length; i++) {
				System.out.print(arr[i]);
			}
			System.out.println();
			return;
		}
		for (int i = index; i < arr.length; i++) {

			// result[index] = arr[i];
			swap(arr, index, i);
			perm1(arr, result, index + 1, count + 1);
			swap(arr, index, i);
		}
	}

	public static void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public static void perm2(int[] arr, int[] result, boolean[] visited, int idx) {
		if (result.length == idx) {
			System.out.println(Arrays.toString(result));
			return;
		}
		for (int i = 0; i < visited.length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				result[idx] = arr[i];
				perm2(arr, result, visited, idx + 1);
				visited[i] = false;
			}
		}
	}
}
