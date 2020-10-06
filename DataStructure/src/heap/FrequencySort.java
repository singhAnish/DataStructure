package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import util.Local;
import util.Pair;


//Time Complexity : O(n*log(n))
//Heapify Complexity : log(n)
public class FrequencySort {

	public static void main(String[] args) {
		int[] input = {1, 2, 2, 3, 3, 3};
		Local local = new Local();
		local.printArray(frequentNumbers(input));
	}
	
	private static int[] frequentNumbers(int[] input) {
		int[] result = new int[input.length];
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : input) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}else {
				map.put(i, 1);
			}
		}
		
		PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Pair<Integer, Integer>> (){
			@Override
			public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
				return b.getValue() - a.getValue();
			}
		});
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
		}
		
		
		int index= 0;
		while(!minHeap.isEmpty()) {
			Pair<Integer, Integer> pair = minHeap.poll();			
			int count = pair.getValue();
			int key = pair.getKey();
			
			while(count > 0) {
				result[index] = key;
				index++;
				count--;
			}			
		}
		
		return result;
	}

}
