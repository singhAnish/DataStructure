package heap;

import java.util.PriorityQueue;

public class RopeConnectionCost {

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		System.out.println("Minimum Cost : " + getMinimumCost(input));
	}

	private static int getMinimumCost(int[] input) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i : input) {
			minHeap.add(i);
		}

		int cost = 0;
		
		while (minHeap.size() > 1) {
			int currentCost = minHeap.poll() + minHeap.poll();
			minHeap.add(currentCost);
			cost = cost + currentCost;
		}
		return cost;
	}

}
