package dp_lcs;

public class LongestCommonSubstringLength {
	public static void main(String[] args) {
		String s1 = "abcxyzwt";
		String s2 = "abcmyzwt";
		System.out.println("Result :\t" + getCount(s1, s2));
	}

	private static int getCount(String text1, String text2) {

		int l1 = text1.length();
		int l2 = text2.length();

		if (l1 == 0 || l2 == 0) {
			return 0;
		}

		int[][] dp = new int[l1 + 1][l2 + 1];
		
		int result = 0;

		for (int i = 0; i <= l1; i++) {
			for (int j = 0; j <= l2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
					result = Math.max(result, dp[i][j]);
				} else {
					dp[i][j] = 0;
				}
			}
		}

		printMatrix(dp);
		return result;
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
