package dp_mcm;

public class EggDroppingRecursion {

	public static void main(String[] args) {

		int floor = 14;
		int eggs = 3;

		int[][] memo = new int[floor + 1][eggs + 1];

		System.out.println("Result : \t" + eggDrop(floor, eggs, memo));

	}

	private static int eggDrop(int eggs, int floor, int[][] memo) {
		if (eggs == 1) {
			return floor;
		}

		if (floor == 1) {
			return 1;
		}

		if (eggs == 0 || floor == 0) {
			return 0;
		}

		if (memo[eggs][floor] > 0) {
			return memo[eggs][floor];
		}

		int ans = Integer.MAX_VALUE;
		for (int i = 1; i <= floor; i++) {

			int trial_egg_break = eggDrop(eggs - 1, floor - 1, memo);
			int trial_egg_survive = eggDrop(eggs, floor - i, memo);

			// Best of the worst or minimum of the max
			ans = Math.min(ans, Math.max(trial_egg_break, trial_egg_survive));
		}
		return memo[eggs][floor] = ans + 1;
	}
}
