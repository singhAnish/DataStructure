package dp_knapsack;

public class MinimumCoinSum {
	
	public static void main(String[] args) {
		int[] coins = {1,2};
		int amount =1;
		
		System.out.println("Result : \t" + getMinCoinCount(coins, amount));
	}
	
	
	private static int getMinCoinCount(int[] coins, int amount) {
		
		int[][] dp = new int[coins.length + 1][amount+1];
		int max =Integer.MAX_VALUE -1;;
		
		for(int i= 0; i<=amount; i++) {
			dp[0][i] = max;
		}
		
		for(int i= 1; i<=coins.length; i++) {
			dp[i][0] = 0;
		}
		
		for(int i= 1; i<=coins.length; i++) {
			for(int j= 1; j<=amount; j++) {
				if(i == 1) {
					if(j% coins[0] == 0) {
						dp[i][j] = j / coins[0];
					}else{
						dp[i][j] = max;
					}
				}else if(coins[i-1] <= j) {
					dp[i][j] = Math.min(dp[i][j - coins[i-1]] +1, dp[i-1][j]);
					
				}else {
					dp[i][j]  = dp[i-1][j];
				}
			}
		}
		return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
	}

}
