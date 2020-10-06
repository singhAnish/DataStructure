package recursion;

import java.util.Stack;

public class StackSortRecursion {

	public static Stack<Integer> stack = new Stack<>();

	public static void main(String[] args) {
		stack.push(9);
		stack.push(2);
		stack.push(7);
		stack.push(4);
		stack.push(6);

		sort();
		System.out.println(stack);
	}

	private static void sort() {
		if (stack.isEmpty()) {
			return;
		}

		int temp = stack.pop();
		sort();

		insertAtCorrectPosition(temp);
	}

	private static void insertAtCorrectPosition(int temp) {
		if (stack.isEmpty() || stack.peek() < temp) {
			stack.push(temp);
			return;
		}

		int top = stack.pop();
		insertAtCorrectPosition(temp);

		stack.push(top);
	}
}
