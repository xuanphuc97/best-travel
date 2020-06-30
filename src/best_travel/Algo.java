package best_travel;

import java.util.List;

public class Algo {
	/*
	 * return result of best travel
	 */
	public static Integer chooseBestSum(int distanceLimitation, int numberOfCities, List<Integer> listOfDistances) {
		if (numberOfCities > listOfDistances.size())
			return null;
		int idx[] = new int[numberOfCities];
		for (int i = 0; i < numberOfCities; i++)
			idx[i] = i;
		int best = 0;
		do {
			int next = value(idx, listOfDistances);
			if (next > best && next <= distanceLimitation)
				best = next;
		} while (!lastComb(idx, listOfDistances.size()));
		return best == 0 ? null : best;
	}

	/*
	 * return sum of list at index in idx[];
	 */
	private static int value(int[] idx, List<Integer> listOfDistances) {
		int sum = 0;
		for (int i = 0; i < idx.length; i++)
			sum += listOfDistances.get(idx[i]);
		return sum;
	}

	/*
	 * return true when no more combinations
	 */
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

	public static void main(String[] args) {
	}
}
