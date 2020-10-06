package sorting;

import java.util.Arrays;

import util.Local;

//Time Complexity : O(n^2)
public class BubbleSort {

	public static void main(String[] args) {
		int[] input2 = { 6, 4, 1, 5, 2 };
		recursionBubbleSort(input2, input2.length);
		System.out.println(Arrays.toString(bubbleSort(input2)));

		int[] input = { 6, 4, 1, 5, 2 };
		System.out.println(Arrays.toString(bubbleSort(input)));
	}

	private static void recursionBubbleSort(int[] input, int n) {
		if (n == 1) {
			return;
		}

		for (int i = 0; i < n - 1; i++) {
			if (input[i] > input[i + 1]) {
				int temp = input[i];
				input[i] = input[i + 1];
				input[i + 1] = temp;
			}
		}
		recursionBubbleSort(input, n - 1);
	}

	private static int[] bubbleSort(int[] input) {
		for (int index1 = 0; index1 < input.length - 1; index1++) {
			for (int index2 = 0; index2 < input.length - 1 - index1; index2++) {
				if (input[index2 + 1] < input[index2]) {
					int temp = input[index2];
					input[index2] = input[index2 + 1];
					input[index2 + 1] = temp;
				}
			}
		}
		return input;
	}

}
