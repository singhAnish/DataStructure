package heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import javafx.util.Pair;
import util.Local;

//Time Complexity : O(n*log(K))
//Space Complexity : O(n + k)
public class KclosestNumber {

	public static void main(String[] args) {
		int[] input = { 0, 1, 2, 3, 4, 6, 7, 10, 15, 20, 14, 19, 12, 17 };

		Local local = new Local();
		local.printIntegerList(getKClosestNumber(input, 4, 15));
	}

	private static List<Integer> getKClosestNumber(int[] input, int k, int number) {

		List<Integer> list = new ArrayList<>();
		PriorityQueue<Pair<Integer, Integer>> maxHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>>() {
			@Override
			public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
				return b.getKey() - a.getKey();
			}
		});

		for (int i = 0; i < input.length; i++) {
			maxHeap.offer(new Pair<>(Math.abs(number - input[i]), input[i]));
			if (maxHeap.size() > k) {
				maxHeap.poll();
			}
		}

		while (!maxHeap.isEmpty()) {
			list.add(maxHeap.poll().getValue());
		}

		return list;
	}

}
