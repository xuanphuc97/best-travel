package best_travel;
import java.util.Arrays;
import java.util.List;

public class Algo {
	// return result of best travel
	public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
		if (k > ls.size())
			return null;
		int idx[] = new int[k];
		for (int i = 0; i < k; i++)
			idx[i] = i;
		int best = 0;
		do {
			int next = value(idx, ls);
			if (next > best && next <= t)
				best = next;
		} while (!lastComb(idx, ls.size()));
		return best == 0 ? null : best;
	}
	// return sum of list at index in idx[];
	private static int value(int[] idx, List<Integer> ls) {
		int sum = 0;
		for (int i = 0; i < idx.length; i++)
			sum += ls.get(idx[i]);
		return sum;
	}

	// return true when no more combinations
	private static boolean lastComb(int[] idx, int range) {
		for (int i = idx.length - 1; i >= 0; i--) {
			idx[i]++;
			if (idx[i] <= range - idx.length + i) {
				for (int j = i + 1; j < idx.length; j++)
					idx[j] = idx[j - 1] + 1;
				return false;
			}
		}
		return true;
	}
	// Test
	public static void main(String[] args) {
		// Test case 1
		System.out.println("Test case 1");
		Integer[] a = {50, 55, 56, 57, 58};
		List<Integer> ls1 = Arrays.asList(a);
		System.out.println(chooseBestSum(163, 3, ls1));
		// Test case 2
		System.out.println("Test case 2");
		Integer[] b = {50, 55, 57, 58, 60};
		List<Integer> ls2 = Arrays.asList(b);
		System.out.println(chooseBestSum(174, 3, ls2));
		// Test case 3
		System.out.println("Test case 3");
		Integer[] c = {91, 74, 73, 85, 73, 81, 87};
		List<Integer> ls3 = Arrays.asList(c);
		System.out.println(chooseBestSum(230, 3, ls3));
	}
}
