package stack;

import java.util.Stack;

import javafx.util.Pair;
import util.Local;

//TIme Complexity : O(n)
//Space Complexity : O(n * 3) ~ O(n)
public class MaximumArea_Histogram {
	
	public static void main(String[] args) {
		int[] input = {6, 2, 5, 4, 5, 1, 6 };
		int result = getMaximumArea(input);
		System.out.println("Maxium Area : " + result);
	}
	
	public static int getMaximumArea(int[] input) {
		if(input.length == 0) {
			return 0;
		} else if(input.length == 1) {
			return input[0];
		}
				
		int[] nearestSmallestToRightIndex = getNearestSmallestToRightIndex(input); //{1, 5, 3, 5, 5, 7, 7}
		int[] nearestSmallestToLeftIndex = getNearestSmallestToLeftIndex(input); //{-1, -1, 1, 1, 3, -1, 5}
		int[] areaArray = new int[input.length]; //{6 10 5 12 5 7 6}
		for(int i = 0; i < input.length; i++) {
			areaArray[i] = input[i] * (nearestSmallestToRightIndex[i] - nearestSmallestToLeftIndex[i] - 1);
		}

		int result = Integer.MIN_VALUE;
		for(int i : areaArray) {
			if(result < i) {
				result = i;
			}
		}
		return result;
	}
	
	private static int[] getNearestSmallestToRightIndex(int[] input){
		int[] result = new int[input.length];
		Stack<Pair<Integer, Integer>> stack = new Stack<>();
		for(int i =  input.length -1; i >= 0 ; i--) {
			if(stack.isEmpty()) {
				result[i] = input.length;
			}else {
				while(!stack.isEmpty()) {
					Pair<Integer, Integer> pair = stack.peek();
					if(pair.getKey() < input[i]) {
						result[i] = stack.peek().getValue();
						break;
					}else {
						stack.pop();
						if(stack.isEmpty()) {
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
	
	
	private static int[] getNearestSmallestToLeftIndex(int[] input){
		int[] result = new int[input.length];
		Stack<Pair<Integer, Integer>> stack = new Stack<>();

		for(int i = 0; i < input.length ; i++) {
			if(stack.isEmpty()) {
				result[i] = -1;
			}else {
				while(!stack.isEmpty()) {
					Pair<Integer, Integer> pair = stack.peek();
					if(pair.getKey() < input[i]) {
						result[i] = stack.peek().getValue();
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
			stack.add(new Pair<>(input[i], i));
		}
		return result;
	}
}
