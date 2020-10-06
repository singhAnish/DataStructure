package recursion;

import java.util.Stack;

public class ReverseStack {

	public static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		reverse();
		System.out.println(stack);

	}
	
	
	private static void reverse() {
		if(stack.isEmpty()) {
			return;
		}
		
		int temp = stack.pop();
		reverse();
		
		insertAtCorrectPosition(temp);
	}
	

	private static void insertAtCorrectPosition(int temp) {
		if (stack.isEmpty() ) {
			stack.push(temp);
			return;
		}

		int top = stack.pop();
		insertAtCorrectPosition(temp);

		stack.push(top);
	}
}
