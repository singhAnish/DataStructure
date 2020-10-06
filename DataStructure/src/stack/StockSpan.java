package stack;

import java.util.Arrays;
import java.util.Stack;
import util.Pair;

public class StockSpan {

	public static void main(String[] args) {
		int[] input = { 100, 80, 60, 70, 60, 75, 85 }; // {1, 1, 1, 2, 1, 4, 6 }
		System.out.println(Arrays.toString(getResult(input)));
	}

	private static int[] getResult(int[] input) {
		int[] result = new int[input.length];
		if(input.length == 0) {
			return result;
		}
		
		Stack<Pair<Integer, Integer>> stack = new Stack<>();
		for (int i = 0; i < input.length; i++) {
			if (stack.isEmpty()) {
				result[i] = 1;
			} else {
				while (!stack.isEmpty()) {
					Pair<Integer, Integer> pair = stack.peek();
					if (pair.getKey() > input[i]) {
						result[i] = (i - stack.peek().getValue());
						break;
					} else {
						stack.pop();
						if (stack.isEmpty()) {
							result[i] = 1;
							break;
						}
					}
				}
			}
			stack.add(new Pair<>(input[i], i));
		}
		return result;
	}
}
