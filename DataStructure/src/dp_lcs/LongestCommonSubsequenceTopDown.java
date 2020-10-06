package dp_lcs;

/*Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.*/

//Time Complexity : O(m*n)
//Space Complexity : O(m*n)

public class LongestCommonSubsequenceTopDown {
	public static void main(String[] args) {
		String s1 = "anhdasf";
		String s2 = "aznhdaksfi";
		System.out.println("Result :\t" + getCount(s1, s2));
	}

	private static int getCount(String text1, String text2) {

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
