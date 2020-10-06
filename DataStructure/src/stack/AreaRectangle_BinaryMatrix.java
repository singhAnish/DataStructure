package stack;

import java.util.Stack;

import javafx.util.Pair;
import util.Local;

public class AreaRectangle_BinaryMatrix {

	public static void main(String[] args) {
		int[][] input = { { 0, 1, 1, 0 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 } };
		System.out.println("MaxAreaRectangleBinaryMatrix : " + getMaxAreaRectangleBinaryMatrix(input));
	}

	public static int getMaxAreaRectangleBinaryMatrix(int[][] input ) {
		int result = 0;
		if(input.length == 0) {
			return result;
		}
		
		int[] compressedArray = new int[input[0].length];	
		for (int row = 0; row < input.length; row++) { 
			for (int column = 0; column < input[row].length; column++) { 
				if(input[row] [column] == 0) {
					compressedArray[column] = 0;
				}else {
					compressedArray[column] = compressedArray[column] + 1;
				}
			} 
			result = Math.max(result, getMaximumArea(compressedArray));
		}		
		return result;	
	}

	public static int getMaximumArea(int[] input) {
		if (input.length == 0) {
			return 0;
		} else if (input.length == 1) {
			return input[0];
		}

		int[] nearestSmallestToRightIndex = getNearestSmallestToRightIndex(input); 
		int[] nearestSmallestToLeftIndex = getNearestSmallestToLeftIndex(input); 
		int[] areaArray = new int[input.length];
		for (int i = 0; i < input.length; i++) {
			areaArray[i] = input[i] * (nearestSmallestToRightIndex[i] - nearestSmallestToLeftIndex[i] - 1);
		}

		int result = Integer.MIN_VALUE;
		for (int i : areaArray) {
			if (result < i) {
				result = i;
			}
		}
		return result;
	}

	private static int[] getNearestSmallestToRightIndex(int[] input) {
		int[] result = new int[input.length];
		Stack<Pair<Integer, Integer>> stack = new Stack<>();
		for (int i = input.length - 1; i >= 0; i--) {
			if (stack.isEmpty()) {
				result[i] = input.length;
			} else {
				while (!stack.isEmpty()) {
					Pair<Integer, Integer> pair = stack.peek();
					if (pair.getKey() < input[i]) {
						result[i] = stack.peek().getValue();
						break;
					} else {
						stack.pop();
						if (stack.isEmpty()) {
							result[i] = input.length;
							break;
						}
					}
				}
			}
			stack.add(new Pair<>(input[i], i));
		}
		return result;
	}

	private static int[] getNearestSmallestToLeftIndex(int[] input) {
		int[] result = new int[input.length];
		Stack<Pair<Integer, Integer>> stack = new Stack<>();

		for (int i = 0; i < input.length; i++) {
			if (stack.isEmpty()) {
				result[i] = -1;
			} else {
				while (!stack.isEmpty()) {
					Pair<Integer, Integer> pair = stack.peek();
					if (pair.getKey() < input[i]) {
						result[i] = stack.peek().getValue();
						break;
					} else {
						stack.pop();
						if (stack.isEmpty()) {
							result[i] = -1;
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
