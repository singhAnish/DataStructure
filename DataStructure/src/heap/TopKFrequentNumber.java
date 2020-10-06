package heap;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;
import util.Local;

//Time Complexity : O(n*log(k)
public class TopKFrequentNumber {
	
	public static void main(String[] args) {
		
		int[] input = {1, 1, 1, 2, 3, 3, 4, 0, 0, 2, 2, 2, 1, 0, 1, 0, 0};
		Local local = new Local();
		local.printArray(frequentNumbers(input, 2));
		
		
	}
	
	private static int[] frequentNumbers(int[] input , int k) {
		int[] result = new int[k];
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i : input) {
			if(map.containsKey(i)) {
				map.put(i, map.get(i) + 1);
			}else {
				map.put(i, 1);
			}
		}
		
		PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>(k + 1, new Comparator<Pair<Integer, Integer>> (){
			@Override
			public int compare(Pair<Integer, Integer> a, Pair<Integer, Integer> b) {
				return a.getValue() - b.getValue();
			}
		});
		
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
			
			if(minHeap.size() > k){
				minHeap.poll();			
			}
		}
		
		int i = k-1;
		while(!minHeap.isEmpty()) {
			result[i] = minHeap.poll().getKey();
			i--;
		}
		return result;
	}

}
