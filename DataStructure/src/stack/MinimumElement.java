package stack;

import java.util.Stack;


//Time Complexity : O(1)
//Space Complexity : O(n)
public class MinimumElement {

	private static Stack<Integer> stack = new Stack<>();
	private static int minElement = Integer.MAX_VALUE;

	public static void main(String[] aregs) {
		push(5);
		push(3);
		push(2);
		System.out.println("peek  : " + peek() + "  min : "+ getMinimum()) ;
		push(7);
		push(1);
		System.out.println("peek  : " + peek() + "  min : "+ getMinimum()) ;
		pop();
		System.out.println("peek  : " + peek() + "  min : "+ getMinimum()) ;	
	}

	private static void push(int x) {
		if (stack.isEmpty()) {
			stack.push(x);
			minElement = x;
		} else {
			if (x < minElement) {
				stack.push(2 * x - minElement);
				minElement = x;
			} else {
				stack.push(x);
			}
		}
	}

	private static void pop() {
		if (stack.peek() < minElement) {
			minElement = 2 * minElement - stack.peek();
			stack.pop();
		} else {
			stack.pop();
		}
	}

	private static int peek() {
		if (stack.peek() < minElement) {
			return minElement;
		}
		return stack.peek();
	}

	private static int getMinimum() {
		if (stack.isEmpty()) {
			return Integer.MIN_VALUE;
		}
		return minElement;
	}

}
