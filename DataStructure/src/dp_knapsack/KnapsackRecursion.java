package dp_knapsack;

import java.util.Arrays;


public class KnapsackRecursion {

	private static int[] values = { 10, 15, 40};
	private static int[] weight = { 1, 2, 3 };
	private static int W = 6;
	private static int[][] memo = new int[values.length + 1][W + 1];

	public static void main(String[] args) {

		for (int[] row : memo) {
			Arrays.fill(row, -1);
		}

		System.out.println("Output \t" + getMaxProfit(weight.length, W));

		for (int i = 0; i < weight.length; i++) {
			for (int j = 0; j < W; j++) {
				System.out.print(memo[i][j] + "\t");
			}
			System.out.println("");
		}

	}

	private static int getMaxProfit(int n, int W) {

		if (W == 0 || n == 0) {
			return 0;
		}

		if (memo[n][W] != -1) {
			return memo[n][W];
		}
		
		if(weight[n - 1] > W) {
			return memo[n-1][W] = getMaxProfit(n - 1, W);
		}else {
			int leftProfit = values[n - 1] + getMaxProfit(n - 1, W - weight[n - 1]);
			int rightProfit = getMaxProfit(n - 1, W);
			if(leftProfit > rightProfit) {
				return memo[n-1][W-1] = leftProfit;
			}else {
				return memo[n-1][W] = rightProfit;
			}
		} 
	}

}
