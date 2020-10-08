package dp_lcs;

import java.util.Arrays;

/*Given two sequences, find the length of longest subsequence present in both of them. 
A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous. 
For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.*/

//Time Complexity : O(2^n)
//Space Complexity : O(m*n)

public class Longest_Common_Subsequence {

	public static void main(String[] args) {
		String s1 = "anhdasf";
		String s2 = "aznhdaksfi";

		int[][] dp = new int[s1.length() + 1][s2.length() + 1];
		for (int i = 0; i < dp.length; i++) {
			Arrays.fill(dp[i], -1);
		}
		System.out.println("Longest Common Subsequence :\t" + getCount(s1, s2, s1.length(), s2.length(), dp));
	}

	private static int getCount(String s1, String s2, int l1, int l2, int[][] dp) {
		if (l1 == 0 || l2 == 0) {
			return 0;
		}

		if (dp[l1][l2] != -1) {
			return dp[l1][l2];
		}

		if (s1.charAt(l1 - 1) == s2.charAt(l2 - 1)) {
			dp[l1][l2] = 1 + getCount(s1, s2, l1 - 1, l2 - 1, dp);
		} else {
			dp[l1][l2] = Math.max(getCount(s1, s2, l1 - 1, l2, dp), getCount(s1, s2, l1, l2 - 1, dp));
		}

		return dp[l1][l2];
	}
}
