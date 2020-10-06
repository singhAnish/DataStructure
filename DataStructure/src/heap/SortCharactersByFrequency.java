package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;
import util.Local;

public class SortCharactersByFrequency {

	public static void main(String[] args) {
		System.out.println("Output : " + frequencySort("free"));
	}

	private static String frequencySort(String s) {

		if (s.length() < 2) {
			return s;
		}

		HashMap<Character, Integer> map = new HashMap<>();
		for (char i : s.toCharArray()) {
			if (map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			} else {
				map.put(i, 1);
			}
		}

		PriorityQueue<Pair<Character, Integer>> minHeap = new PriorityQueue<>(
				new Comparator<Pair<Character, Integer>>() {
					@Override
					public int compare(Pair<Character, Integer> a, Pair<Character, Integer> b) {
						return b.getValue() - a.getValue();
					}
				});

		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
		}

		StringBuilder builder = new StringBuilder();
		while (!minHeap.isEmpty()) {
			Pair<Character, Integer> pair = minHeap.poll();
			int count = pair.getValue();
			char key = pair.getKey();

			while (count > 0) {
				builder.append(key);
				count--;
			}
		}
		return builder.toString();
	}
}
