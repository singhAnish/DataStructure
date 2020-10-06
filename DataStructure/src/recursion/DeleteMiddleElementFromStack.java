package recursion;

import java.util.Stack;


//Time Complexity : O(2^k)
public class DeleteMiddleElementFromStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();

		stack.push(6);
		stack.push(5);
		stack.push(4);
		stack.push(3);
		stack.push(2);
		stack.push(1);

		deleteMiddleElement(stack, stack.size());
		System.out.println(stack);
	}

	private static void deleteMiddleElement(Stack<Integer> stack, int size) {
		if (stack.isEmpty()) {
			return;
		} else if (size % 2 == 0 && stack.size() == size / 2) {
			stack.pop();
			return;
		} else if (size % 2 == 1 && stack.size() - 1 == size / 2) {
			stack.pop();
			return;
		}

		int temp = stack.pop();
		deleteMiddleElement(stack, size);

		stack.push(temp);

	}
}
