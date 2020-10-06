package dp_mcm;

import java.util.Arrays;

public class MCMBottomUp {

	public static void main(String[] args) {
		int[] input = { 10, 20, 30, 40, 30 };
		int[][] dp = new int[input.length + 1][input.length + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		System.out.println("Result : \t" + getCost(input, 1, input.length - 1, dp));
	}

	private static int getCost(int[] input, int i, int j, int[][] dp) {

		if (i >= j) {
			return 0;
		}

		if (dp[i][j] != -1) {
			return dp[i][j];
		}

		int minCost = Integer.MAX_VALUE;
		for (int k = i; k < j; k++) {
			dp[i][j] = getCost(input, i, k, dp) + getCost(input, k + 1, j, dp) + (input[i - 1] * input[k] * input[j]);

			minCost = Math.min(minCost, dp[i][j]);
		}

		return minCost;
	}

}
