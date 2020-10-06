package dp_knapsack;

import java.util.Arrays;

public class TargetSum {

	public static void main(String[] args) {
		int[] input = { 0, 0, 0, 0, 0, 0, 0, 0, 1 };
		int sum = 1;

		System.out.println("Output : \t" + findTargetSumWays(input, sum));

	}

	public static int findTargetSumWays(int[] nums, int S) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		} else if (n == 1) {
			return nums[0] == Math.abs(S) ? 1 : 0;
		}

		int sum = 0;
		for (int i : nums) {
			sum += i;
		}
		if (S > sum) {
			return 0;
		}
		sum = (sum + S) / 2;

		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i <= sum; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}
}
