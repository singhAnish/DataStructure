package heap;

import java.util.PriorityQueue;

//Time Complexity : O(n*log(k)
public class KthLargetElement {

	public static void main(String[] args) {
		int[] input = { 3, 4, 15, 7, 20, 10 };
		System.out.println(getKLargestElement(input, 3));
	}

	private static int getKLargestElement(int[] input, int k) {
		if (input.length == 0) {
			return 0;
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<>(k);
		for (int num : input) {
			minHeap.offer(num);
			if (minHeap.size() > k) {
				minHeap.poll();
			}
		}

		return minHeap.poll();
	}

}
