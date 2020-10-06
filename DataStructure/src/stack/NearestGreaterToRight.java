package stack;

import java.util.Stack;

import util.Local;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class NearestGreaterToRight {
	
	public static void main(String[] args) {
		//int[] input = {1, 3, 0, 0, 1, 2, 4};     // {3, 4, 1, 1, 2, 4, -1} 
		int[] input = {4, 5, 2, 25};     // { -1, 12, 12, -1} 
		Local local = new Local();
		local.printArray(result(input));
	}
	
	
	private static int[] result(int[] input) {
		
		 int[] result = new int[input.length];
		 if (input.length == 1) {
			 result[0] = -1;
			 return result;
		 }
		 
		 Stack<Integer> stack = new Stack<>();
		 for(int i = input.length -1; i >=0; i--) {
			 if(stack.isEmpty()) {
				 result[i] = -1;
			 }else {
				 int value = input[i];
				 while(!stack.isEmpty()) {
					 	if(stack.peek() > value) {
							 result[i] = stack.peek();
							 break;
						 }else {
							 stack.pop();
							 if(stack.isEmpty()) {
								 result[i] = -1;
							 }
						 }			 
				 } 	 
			}
			stack.add(input[i]);
		 }
		 
		return result;
	}
}
