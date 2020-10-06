package sorting;

import java.util.Arrays;


//Time Complexity : O(n*log(n))
//Space Complexity : O(n)
public class MergeSort {

	private static int[] input = { 5, 3, 6, 7, 9, 1, 8, 2, 4 };
	private static int[] helper = new int[input.length];

	public static void main(String[] args) {
		mergeSort(0, input.length - 1);
		System.out.println(Arrays.toString(input));
	}

	private static void mergeSort(int start, int end) {
		if (start < end) {
			int middle = start + (end - start) / 2; 
			mergeSort(start, middle);
			mergeSort(middle + 1, end);
			
			merge(start, middle, end);
		}
	}

	private static void merge(int start, int middle, int end) {

		for (int index = start; index <= end; index++) {
			helper[index] = input[index];
		}

		int i = start;
		int j = middle + 1;
		int k = start;

		while (i <= middle && j <= end) {
			if (helper[i] <= helper[j]) {
				input[k] = helper[i];
				i++;
			} else {
				input[k] = helper[j];
				j++;
			}
			k++;
		}

		while (i <= middle) {
			input[k] = helper[i];
			i++;
			k++;
		}
	}

}
