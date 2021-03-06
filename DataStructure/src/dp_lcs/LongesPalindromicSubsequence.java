package dp_lcs;


//Given a sequence, find the length of the longest palindromic subsequence in it.
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class LongesPalindromicSubsequence {

	public static void main(String[] args) {
		String s1 = "agbcbga";
		System.out.println("Longes Palindromic Subsequence :\t" + getCount(s1));
	}

	private static int getCount(String text1) {

		StringBuilder builder = new StringBuilder();
		for (int i = text1.length() - 1; i >= 0; i--) {
			builder.append(text1.charAt(i));
		}

		String text2 = builder.toString();

		int l1 = text1.length();
		int l2 = text2.length();

		if (l1 == 0 || l2 == 0) {
			return 0;
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
		return dp[l1][l2];
	}

}
