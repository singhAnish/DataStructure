package stack;

import java.util.Stack;

import util.Local;


//Time Complexity : O(n)
//Space Complexity : O(n)
public class NearestGreaterToLeft {

	public static void main(String[] args) {
		int[] input = {1, 3, 0, 0, 1, 2, 4};     // {-1, -1, 3, 3, 3, 3, -1} 
		//int[] input = {1, 3, 2, 4};     // { -1, -1, 3, -1} 
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
		 for(int i = 0; i< input.length; i++) {
			 if(stack.isEmpty()) {
				 result[i] = -1;
			 }else {
				 while(!stack.isEmpty()) {
					 if(stack.peek() >  input[i]) {
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
