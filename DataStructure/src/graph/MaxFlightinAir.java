package graph;

import java.util.*;

public class MaxFlightinAir {

	public static void main(String[] args) {
		List<Flight> flightList = new ArrayList<>();
		flightList.add(new Flight(4, 8));
		flightList.add(new Flight(2, 5));
		flightList.add(new Flight(17, 20));
		flightList.add(new Flight(10, 21));
		flightList.add(new Flight(9, 18));

		System.out.println("Maximum Flight in Air at a time : \t" + getMaximumFlightCountinAir(flightList));
	}

	// Method to return max flight in air at a particular moment
	private static int getMaximumFlightCountinAir(List<Flight> flights) {

		int maxCount = 0;
		flights.sort(new Comparator<Flight>() {
			@Override
			public int compare(Flight o1, Flight o2) {
				return o1.start - o2.start;
			}
		});

		PriorityQueue<Flight> minHeap = new PriorityQueue<>(new Comparator<Flight>() {
			@Override
			public int compare(Flight o1, Flight o2) {
				return o1.end - o2.end;
			}
		});

		for (Flight flight : flights) {
			while (!minHeap.isEmpty() && minHeap.peek().end < flight.start) {
				System.out.println("flight : "+ minHeap.peek().end + "\t"+ flight.start);
				minHeap.poll();
			}

			minHeap.add(flight);
			maxCount = Math.max(maxCount, minHeap.size());
		}
		
		return maxCount;
	}

	static class Flight {
		int start;
		int end;

		public Flight(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
