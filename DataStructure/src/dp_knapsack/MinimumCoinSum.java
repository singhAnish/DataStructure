package dp_knapsack;

import java.util.Arrays;

import util.Local;

//Problem Statement : Find minimum number of coins that make a given value
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

public class MinimumCoinSum {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3, 4 };
		int sum = 5;

		// Top Down solution
		System.out.println("Result : \t" + getMinCoinCount(coins, sum));

		// Solution using recursion
		int[] dp = new int[sum + 1];
		Arrays.fill(dp, -1);
		dp[0] = 0;
		System.out.println("Result using recursion: \t" + minCoins(sum, coins, dp));
	}

	private static int getMinCoinCount(int[] coins, int amount) {

		int[][] dp = new int[coins.length + 1][amount + 1];
		int max = Integer.MAX_VALUE - 1;
		;

		for (int i = 0; i <= amount; i++) {
			dp[0][i] = max;
		}

		for (int i = 1; i <= coins.length; i++) {
			dp[i][0] = 0;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (i == 1) {
					if (j % coins[0] == 0) {
						dp[i][j] = j / coins[0];
					} else {
						dp[i][j] = max;
					}
				} else if (coins[i - 1] <= j) {
					dp[i][j] = Math.min(dp[i][j - coins[i - 1]] + 1, dp[i - 1][j]);
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		Local.printMatrix(dp);

		return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
	}

	
	
	// Using Recursion
	private static int minCoins(int sum, int[] coins, int dp[]) {
		if (sum == 0)
			return 0;

		int ans = Integer.MAX_VALUE;
		for (int i = 0; i < coins.length; i++) {
			if (sum - coins[i] >= 0) {
				int subAns = 0;
				
				if (dp[sum - coins[i]] != -1) {
					subAns = dp[sum - coins[i]];
				} else {
					subAns = minCoins(sum - coins[i], coins, dp);
				}
				
				if (subAns != Integer.MAX_VALUE && subAns + 1 < ans) {
					ans = subAns + 1;
				}
			}
		}
		return dp[sum] = ans;
	}

}
