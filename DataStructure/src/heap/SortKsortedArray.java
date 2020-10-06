package heap;

import java.util.PriorityQueue;

import util.Local;

//Time Complexity : O(n*log(k))
public class SortKsortedArray {

	public static void main(String[] args) {
		
		int[] input = { 6, 5, 3, 2, 8, 10, 9 };

		Local local = new Local();
		local.printArray(getSortedArray(input, 3));
	}

	private static int[] getSortedArray(int[] input, int k) {
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();
		int index = 0;
		for (int i = 0; i < input.length; i++) {
			maxHeap.offer(input[i]);
			if (maxHeap.size() > k) {
				input[index] = maxHeap.poll();
				index++;
			}
		}

		while (!maxHeap.isEmpty()) {
			input[index] = maxHeap.poll();
			index++;
		}
		return input;
	}

}
