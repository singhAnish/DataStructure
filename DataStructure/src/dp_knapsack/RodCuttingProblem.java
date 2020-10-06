package dp_knapsack;

public class RodCuttingProblem {
	
	public static void main(String[] args) {
		int[] size = {1, 2, 3, 4, 5, 6, 7, 8};
		int[] values = {1,   5,   8,   9,  10,  17,  17,  20};
		int length = 8;
		System.out.println("Output : " + getProfit(size, values, length));
	}
	
	private static int getProfit(int[] size, int[] values, int length) {
		int[][] dp = new int[size.length+1][length+1];
		
		for(int i = 0; i<= size.length; i++) {
			for(int j = 0; j<= length; j++) {
				if(i== 0 || j==0) {
					dp[i][j] = 0;
				}else if(size[i-1] <= j) {
					dp[i][j] = Math.max(values[i-1] + dp[i][j-size[i-1]], dp[i-1][j]);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}	
		}
		return dp[size.length][length];
	}
}
