package dp_lcs;

import java.util.Stack;

public class PrintingLongestCommonSubstring {
	public static void main(String[] args) {
		String s1 = "sea";
		String s2 = "eat";
		System.out.println("Result :\t" + getCount(s1, s2));
	}

	private static String getCount(String text1, String text2) {

		int l1 = text1.length();
		int l2 = text2.length();

		if (l1 == 0 || l2 == 0) {
			return "";
		}

		int[][] dp = new int[l1 + 1][l2 + 1];

		int result = 0;

		int m = 0, n = 0;

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					if (dp[i][j] > result) {
						result = dp[i][j];
						m = i;
						n = j;
					} else {

					}
				} else {
					dp[i][j] = 0;
				}
			}
		}

		printMatrix(dp);
		
		System.out.println("m : \t"+ m + "\t\tn :\t"+n);

		Stack<Character> stack = new Stack<>();
		while (m > 0 && n > 0) {
			System.out.println("m : \t"+ m + "\t\tn :\t"+n);

			if (text1.charAt(m - 1) == text2.charAt(n - 1)) {
				stack.push(text1.charAt(m - 1));
				m--;
				n--;
			} else {
				if (dp[m - 1][n] == 0 && dp[m][n - 1] == 0) {
					break;
				}

				if (dp[m - 1][n] > dp[m][n - 1]) {
					m--;
				} else {
					n--;
				}
			}
		}

		StringBuilder builder = new StringBuilder();
		while (!stack.isEmpty()) {
			builder.append(stack.pop());
		}
		return builder.toString();
	}

	private static void printMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println("");
		}
	}
}
