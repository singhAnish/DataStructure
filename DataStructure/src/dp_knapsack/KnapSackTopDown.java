package dp_knapsack;

import util.Local;

//Given weights and values of n items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class KnapSackTopDown {

	public static void main(String[] args) {

		int[] values = { 10, 15, 40 };
		int[] weight = { 1, 2, 3 };
		int capacity = 6;

		 System.out.println("Output : \t" + getMaxResult(values, weight, capacity));
	}

	private static int getMaxResult(int[] values, int[] weight, int capacity) {

		int n = weight.length;
		int[][] memo = new int[n + 1][capacity + 1];

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < capacity + 1; j++) {
				if (i == 0 || j == 0) {
					memo[i][j] = 0;
				} else if (weight[i - 1] <= j) {
					memo[i][j] = Math.max(values[i - 1] + memo[i - 1][j - weight[i - 1]], memo[i - 1][j]);
				} else {
					memo[i][j] = memo[i - 1][j];
				}
			}
		}
		Local.printMatrix(memo);
		return memo[n][capacity];
	}
}
