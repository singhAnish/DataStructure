package recursion;

import java.util.ArrayList;
import java.util.List;

public class Subset {
	
	public static void main(String[] args) {
		int[] input = {1, 2, 3};
		
		System.out.println("subsets : " + subsets(input) );
	}
	
	private static List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> result = new ArrayList<>();
		if(nums.length == 0) {
			return result;
		}
		getAllSubset(nums, 0, new ArrayList<>(), result);
		return result;
	}
	
	private static void getAllSubset(int[] nums, int position, List<Integer> subset,  List<List<Integer>> result ) {
		result.add(new ArrayList<Integer>(subset));

		for(int i = position; i < nums.length; i++) {
			subset.add(nums[i]);
			getAllSubset(nums, i +1, subset, result);
			subset.remove(subset.size() -1);	
		}	
	}
}
