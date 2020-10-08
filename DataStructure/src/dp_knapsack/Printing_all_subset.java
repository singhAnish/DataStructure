package dp_knapsack;

import java.util.ArrayList;
import java.util.List;

//Time Complexity : O(K^n)
public class Printing_all_subset {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };

		List<List<Integer>> list = subsets(nums);
	}

	private static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		
		getAllSubset(nums, 0, new ArrayList<Integer>(), result);
		return result;
		
	}

	private static void getAllSubset(int[] nums, int currentIndex, List<Integer> subset, List<List<Integer>> result) {
		
		result.add(new ArrayList<Integer>(subset));
	
		for (int i = currentIndex; i < nums.length; i++) {
			subset.add(nums[i]);
			getAllSubset(nums, i + 1, subset, result);
			subset.remove(subset.size() - 1);
		}
		
	}

}
