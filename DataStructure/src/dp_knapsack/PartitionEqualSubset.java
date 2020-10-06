package dp_knapsack;


//find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
//Time Complexity : O(m*n)
//Space Complexity : O(m*n)
public class PartitionEqualSubset {
	
	public static void main(String[] args) {
		int arr[] = { 1, 5, 11, 5 };
		System.out.println("Can be divided into two " + findPartition(arr));
	}

	private static boolean findPartition(int nums[]) {
		
		int sum = 0;
		for (int i : nums) {
			sum += i;
		}

		if (sum % 2 != 0) {
			return false;
		}

		int n =  nums.length;
		int W = sum / 2;
		boolean[][] part = new boolean[n + 1][W + 1];

		for (int i = 0; i <= W; i++) {
			part[0][i] = false;
		}

		for (int i = 0; i <= n; i++) {
			part[i][0] = true;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= W; j++) {
				if (nums[i - 1] <= j) {
					part[i][j] = part[i - 1][j - nums[i - 1]] || part[i-1][j];
				} else {
					part[i][j] = part[i - 1][j];
				}
			}
		}
		return part[n][W];
	}
}
