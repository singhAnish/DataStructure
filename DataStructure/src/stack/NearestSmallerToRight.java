package stack;

import java.util.Stack;

import util.Local;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class NearestSmallerToRight {
	
	public static void main(String[] args) {
		int[] input = {4, 5, 2, 10, 8} ; // {2, 2, -1, 8, -1}   
		Local local = new Local();
		local.printArray(result(input));
	}

	
	private static int[] result(int[] input) {
		int[] result = new int[input.length];
		if(input.length == 1) {
			result[0] = -1;
			return result;
		}
		
		Stack<Integer> stack = new Stack<>();
		for(int i = input.length -1; i >=0 ;  i--) {
			if(stack.isEmpty()) {
				result[i] = -1;
			}else {
				while(!stack.isEmpty()) {
					if(stack.peek() < input[i]) {
						result[i] = stack.peek();
						break;
					}else {
						stack.pop();
						if(stack.isEmpty()) {
							result[i] = -1;
							break;
						}
					}	
				}	
			}
			stack.add(input[i]);
		}
		return result;
	}
}
