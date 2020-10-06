package dp_lcs;

import java.util.Stack;

// Minimum number of deletions and insertions to transform one string into another
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class Minimum_Deletions_Insertions_Transform {
	
	public static void main(String[] args) {
		String str1 = "heap";
		String str2 = "pea";
		System.out.println("Minimum Insertion and deletion : \t" + minDistance(str1, str2));
	}

	
	 public static int minDistance(String word1, String word2) {
	        int count = getCommonSubsequence(word1, word2);
			return (word1.length() - count) +( word2.length() -count);
	    }
	    
	    private static int getCommonSubsequence(String text1, String text2) {
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
			
			Stack<Character> stack = new Stack<>();
			while (l1 > 0 && l2 > 0) {
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
			return builder.toString().length();
		}
}
