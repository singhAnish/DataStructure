package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;
import util.Local;

//Time Complexity : O(n*log(k)
public class TopKFrequentWords {

	public static void main(String[] args) {
		String[] input = { "i", "love", "leetcode", "i", "love", "coding" };
		Local local = new Local();
		local.printList(topKFrequent(input, 2));

	}

	public static List<String> topKFrequent(String[] words, int k) {

		List<String> list = new ArrayList<>(k);
		HashMap<String, Integer> map = new HashMap<>();
		for (String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}

		PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
			@Override
			public int compare(String str1, String str2) {
				if (map.get(str1).equals(map.get(str2))) {
					return str2.compareTo(str1);
				} else {
					return map.get(str1) - map.get(str2);
				}
			}
		});

		for (String word : map.keySet()) {
			heap.offer(word);
			if (heap.size() > k) {
				heap.poll();
			}
		}

		while (!heap.isEmpty()) {
			list.add(heap.poll());
		}
		Collections.reverse(list);
		return list;
	}

}
