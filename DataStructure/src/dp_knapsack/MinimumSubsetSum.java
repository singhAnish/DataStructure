package dp_knapsack;

import java.util.Arrays;

import util.Local;



//Partition a set into two subsets such that the difference of subset sums is minimum

public class MinimumSubsetSum {

	public static void main(String[] args) {
		int[] input = { 1, 2, 5, 15 };
		System.out.println("Min subset Sum : " + minSubsetSum(input));

	}

	private static int minSubsetSum(int[] input) {

		int n = input.length;
		if (n == 0) {
			return 0;
		}

		int sum = 0;
		for (int i : input) {
			sum += i;
		}

		boolean[][] dp = new boolean[n + 1][sum + 1];

		for (int i = 0; i <= sum; i++) {
			dp[0][i] = false;
		}

		for (int i = 0; i <= n; i++) {
			dp[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= sum; j++) {
				if (input[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - input[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		
		
		/*
		 * Range of subset will be between 0 to sum. 
		 * S1+ S2 = Sum
		 * S2  =  Sum - S1
		 * Math.abs(S1 - (Sum - S1)) // We require this indirectly
		*/
		
		int[] sumArray = new int[sum / 2 + 1];
		for (int i = 0; i < sumArray.length; i++) {
			if (dp[n][i]) {
				sumArray[i] = i;
			} else {
				sumArray[i] = -1;
			}
		}

		int mn = Integer.MAX_VALUE;
		for (int i = 0; i < sumArray.length; i++) {
			if (sumArray[i] != -1) {
				mn = Math.min(mn, sum - 2 * sumArray[i]);
			}
		}
		
		System.out.println(Arrays.toString(sumArray));


		return mn;
	}

}
