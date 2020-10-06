package dp_mcm;

public class EggDroppingProblem {

	public static void main(String[] args) {
		int floor = 14;
		int eggs = 3;
		System.out.println("Egg Dropping Problem : \t" + getMinimumAttempt(eggs, floor));
	}

	private static int getMinimumAttempt(int eggs, int floor) {
		if (floor == 0 || floor == 1 || eggs == 1) {
			return floor;
		}

		int[][] dp = new int[eggs + 1][floor + 1];

		for (int i = 1; i <= eggs; i++) {
			for (int j = 0; j <= floor; j++) {
				if (floor == 1) {
					dp[i][j] = 1;
				} else if (i == 1) {
					dp[i][j] = j;
				} else {
					int ans = Integer.MAX_VALUE;
					for (int k = 1; k < floor; k++) {
						int trial_egg_break = dp[eggs - 1][floor - 1];
						int trial_egg_survive = dp[eggs - 1][floor - i];
						// Best of the worst or minimum of the max
						ans = Math.min(ans, Math.max(trial_egg_break, trial_egg_survive));
					}
					dp[i][j] = ans + 1;
				}
			}
		}

		return dp[eggs][floor];
	}

}
