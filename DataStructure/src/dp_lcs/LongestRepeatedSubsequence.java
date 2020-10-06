package dp_lcs;

import java.util.Stack;

public class LongestRepeatedSubsequence {

	public static void main(String[] args) {
		String s1 = "AABEBCDD";
		System.out.println("Result :\t" + getCount(s1));
	}

	private static String getCount(String text1) {

		int n = text1.length();
		int[][] dp = new int[n + 1][n + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				dp[i][j] = 0;
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (text1.charAt(i - 1) == text1.charAt(j - 1) && i != j)
					dp[i][j] = 1 + dp[i - 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
			}
		}

		Stack<Character> stack = new Stack<>();
		int i = n, j = n;
		while (i > 0 && j > 0) {
			if (dp[i][j] == dp[i - 1][j - 1] + 1) {
				stack.push(text1.charAt(i - 1));
				i--;
				j--;
			} else if (dp[i][j] == dp[i - 1][j]) {
				i--;
			} else {
				j--;
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}
}
