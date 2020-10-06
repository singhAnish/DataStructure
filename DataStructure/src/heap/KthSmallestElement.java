	package heap;

import java.util.Comparator;
import java.util.PriorityQueue;


//Time Complexity : O(n*log(k)
public class KthSmallestElement {

	public static void main(String[] args) {
		int[] input = { 3, 4, 15, 7, 20, 10 };
		System.out.println(getKSmallElement(input, 3));
	}

	private static int getKSmallElement(int[] input, int k) {
		
		if (input.length == 0) {
			return 0;
		}
		
		//PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, Comparator.reverseOrder());
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return b - a;
			}
		});
		
		for (int i : input) {
			maxHeap.offer(i);
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}
		
		return maxHeap.poll();
	}
}
