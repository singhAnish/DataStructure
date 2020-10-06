package dp_knapsack;

//Count of subsets with sum equal to X
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

public class SubsetCount {

	public static void main(String[] args) {
		int[] arr = { 6, 1, 5, 11, 4, 2 };
		int weight = 11;
		System.out.println("Subset Count : \t " + getSubsetCount(arr, weight));
	}

	private static int getSubsetCount(int[] nums, int w) {

		int n = nums.length;
		if (n == 0) {
			return 0;
		}

		int[][] dp = new int[n + 1][w + 1];
		for (int i = 0; i <= w; i++) {
			dp[0][i] = 0;
		}
		for (int i = 0; i <= n; i++) {
			dp[i][0] = 1;
		}
		
		for(int i = 1; i<= n; i++) {
			for (int j=1; j<= w; j++) {
				if(nums[i-1] <= j) {
					dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[n][w];
	}
}
