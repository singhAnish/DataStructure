package recursion;

public class KthSymbolGrammer {

	public static void main(String[] args) {
		System.out.println("Answer is \t\t\t\t\t\t\t\t: " + solve(4, 6));
	}

	private static int solve(int n, int k) {
		if (n == 1) {
			return 0;
		}

		int mid = (int) Math.pow(2, n - 1) / 2;
		if (k <= mid) {
			return solve(n - 1, k);
		} else {
			return solve(n - 1, k - mid) == 0 ? 1 : 0;
		}
	}

}
