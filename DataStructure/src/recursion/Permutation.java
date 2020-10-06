package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

	public static void main(String[] args) {
		int[] arr = { 1, 1, 2 };
		System.out.println(permute(arr).toString());
	}

	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length == 0) {
			return result;
		}
		
		boolean[] used = new boolean[nums.length];
		getAllPermute(nums, new ArrayList<>(), result, used);
		
		return result;
	}

	private static void getAllPermute(int[] nums, List<Integer> subset, List<List<Integer>> result, boolean[] used) {
		if (subset.size() == nums.length) {
			result.add(new ArrayList<Integer>(subset));
			return;
		}
		
		for (int i = 0; i < nums.length; i++) {
			if (!used[i]) {
				subset.add(nums[i]);
				used[i] = true;
				getAllPermute(nums, subset, result, used);
				subset.remove(subset.size() - 1);
				used[i] = false;
			}	
		}
	}

}
