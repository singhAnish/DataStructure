package dp_mcm;

import java.util.Arrays;

public class EggDroppingProblem {

	public static void main(String[] args) {

		int floor = 14;
		int eggs = 3;

		int[][] dp = new int[floor + 1][eggs + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}

		System.out.println("Result : \t" + getMinimumAttempt(floor, eggs, dp));

	}

	private static int getMinimumAttempt(int floor, int eggs, int[][] dp) {

		if (floor == 0 || floor == 1 || eggs == 1) {
			return floor;
		}

		if (dp[floor][eggs] != -1) {
			return dp[floor][eggs];
		}
		int minimumAttempt = Integer.MAX_VALUE;

		for (int i = 1; i <= floor; i++) {
			
			int high;
			if(dp[i-1][ eggs - 1] != -1) {
				high = dp[i-1][ eggs - 1];
			}else {
				high = getMinimumAttempt(i - 1, eggs - 1, dp);
				dp[i-1][ eggs - 1] = high;
			}
			
			
			int low;
			if(dp[floor - i][ eggs] != -1) {
				low = dp[floor - i][ eggs];
			}else {
				low = getMinimumAttempt(floor - i, eggs, dp);
				dp[floor - i][ eggs] = low;
			}
			
			
			int temp = 1 + Math.max(high, low);
			minimumAttempt = Math.min(minimumAttempt, temp);
		}

		return dp[floor][eggs] = minimumAttempt;
	}

}
