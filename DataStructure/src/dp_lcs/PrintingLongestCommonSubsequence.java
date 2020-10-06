package dp_lcs;

import java.util.Stack;

import util.Local;

//Printing Longest Common Subsequence
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

public class PrintingLongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "anhdasf";
		String s2 = "aznhdaksfi";
		System.out.println("Result :\t" + getCount(s1, s2));
	}

	private static String getCount(String text1, String text2) {

		int l1 = text1.length();
		int l2 = text2.length();

		if (l1 == 0 || l2 == 0) {
			return "";
		}

		int[][] dp = new int[l1 + 1][l2 + 1];

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		Local.printMatrix(dp);

		Stack<Character> stack = new Stack<>();
		while (l1 > 0 || l2 > 0) {
			if (text1.charAt(l1 - 1) == text2.charAt(l2 - 1)) {
				stack.push(text1.charAt(l1 - 1));
				l1--;
				l2--;
			} else {
				if (dp[l1 - 1][l2] > dp[l1][l2 - 1]) {
					l1--;
				} else {
					l2--;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}
}
