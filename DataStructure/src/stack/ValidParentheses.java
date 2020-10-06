package stack;

import java.util.Stack;

//Time Complexity : O(n)
//Space Complexity : O(n)
public class ValidParentheses {

	private static  boolean isValid(String s) {
		if (s.length() % 2 != 0) {
			return false;
		}
		Stack<Character> charStack = new Stack<>();

		for (Character c : s.toCharArray()) {
			if (c == '(' || c == '{' || c == '[') {
				charStack.push(c);
			} else if (!charStack.isEmpty()) {
				if (c == ')' && charStack.peek() == '(') {
					charStack.pop();
				} else if (c == '}' && charStack.peek() == '{') {
					charStack.pop();
				} else if (c == ']' && charStack.peek() == '[') {
					charStack.pop();
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		return charStack.isEmpty();
	}
}
