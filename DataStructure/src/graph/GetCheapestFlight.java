package graph;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class GetCheapestFlight {

	public static void main(String[] args) {

		int[][] flights = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
		int src = 0;
		int dest = 2;
		int stopCount = 1;

		int cheapestFlight = findCheapestPrice(flights.length, flights, src, dest, stopCount);
		
		System.out.println("Cost : "+ cheapestFlight);
	}

	private static int findCheapestPrice(int n, int[][] flights, int src, int dst, int stopCount) {

		Map<Integer, List<Flight>> map = new HashMap<Integer, List<Flight>>();

		for (int[] f : flights) {
			Flight flight = new Flight(f[0], f[1], f[2]);

			List<Flight> list;
			if (map.containsKey(f[0])) {
				list = map.get(f[0]);
			} else {
				list = new ArrayList<>();
			}

			list.add(flight);
			map.put(f[0], list);
		}

		PriorityQueue<DestinationCost> queue = new PriorityQueue<>(new Comparator<DestinationCost>() {
			@Override
			public int compare(DestinationCost o1, DestinationCost o2) {
				return Integer.compare(o1.cost, o2.cost);
			}
		});

		queue.offer(new DestinationCost(src, 0, stopCount));
		while (!queue.isEmpty()) {
			DestinationCost costObj = queue.poll();

			if (costObj.src == dst) {
				return costObj.cost;
			}

			if (costObj.stopCount >= 0) {
				if (map.containsKey(costObj.src)) {
					for (Flight flight : map.get(costObj.src)) {
						queue.offer(new DestinationCost(flight.dest, costObj.cost + flight.cost, costObj.stopCount - 1));
					}
				}
			}
		}
		
		return -1;
	}

	static class Flight {
		int src;
		int dest;
		int cost;

		public Flight(int src, int dest, int cost) {
			this.src = src;
			this.dest = dest;
			this.cost = cost;
		}
	}

	static class DestinationCost {
		int src;
		int cost;
		int stopCount;

		public DestinationCost(int src, int cost, int stopCount) {
			this.src = src;
			this.cost = cost;
			this.stopCount = stopCount;
		}
	}

}
