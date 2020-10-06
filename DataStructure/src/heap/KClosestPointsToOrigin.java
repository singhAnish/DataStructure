package heap;

import java.util.Comparator;
import java.util.PriorityQueue;

import util.Local;
import util.Pair;

//Time Complexity : O(n*log(k)
public class KClosestPointsToOrigin {

	public static void main(String[] args) {
		int[][] input = { { 3, 3 }, { 5, -1 }, { -2, 4 }, {0, 0 }, {10, 6}};
		Local local = new Local();
		local.printMatrix(kClosest(input, 3));
	}

	public static int[][] kClosest(int[][] points, int K) {
		
		PriorityQueue<Pair<Integer, Pair<Integer, Integer>>> heap = new PriorityQueue<>(
				new Comparator<Pair<Integer, Pair<Integer, Integer>>>() {
					@Override
					public int compare(Pair<Integer, Pair<Integer, Integer>> o1,
							Pair<Integer, Pair<Integer, Integer>> o2) {
						return o2.getKey() - o1.getKey();
					}
				});

		for (int i = 0; i < points.length; i++) {
			int distance = getDistance(points[i]);
			Pair<Integer, Integer> pair =  new Pair<>(points[i][0], points[i][1]);
			heap.add(new Pair<>(distance, pair));
			if(heap.size() > K) {
				heap.poll();
			}
		}

		
		int[][] result = new int[K][2];
		
		int i = 0;
		while(!heap.isEmpty()) {
			result[i] = getPoint(heap.poll().getValue());
			i++;
		}
		
		return result;
	}

	private static int getDistance(int[] point) {
		return (point[0] * point[0]) + (point[1] * point[1]);
	}
	
	private static int[] getPoint(Pair<Integer, Integer> pair) {
		int[] arr = new int[2];
		arr[0] = pair.getKey();
		arr[1] = pair.getValue();
		return arr;
	}

}
