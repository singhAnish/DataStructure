package dp_knapsack;

import util.Local;


//Problem Statement : how many ways can we make the change? The order of coins doesn’t matter.
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class CoinChangeProblem {

	public static void main(String[] args) {
		int[] coins = { 1, 2, 3 };
		int sum = 5;
		System.out.println("Result : " + getCoinsCount(coins, sum));	
	}

	private static int getCoinsCount(int[] coins, int amount) {

		int[][] dp = new int[coins.length + 1][amount + 1];

		for (int i = 0; i <= amount; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= coins.length; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				if (coins[i - 1] <= j) {
					dp[i][j] = dp[i][j - coins[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		Local.printMatrix(dp);
		return dp[coins.length][amount];
	}
}
