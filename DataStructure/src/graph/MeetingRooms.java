package graph;

import java.util.Arrays;
import java.util.PriorityQueue;

//Time Complexity : O(n*log(n))
//Space Complexity : O(n)

public class MeetingRooms {

	public static void maion(String[] args) {

		Interval[] intervals = new Interval[3];
		intervals[0] = new Interval(0, 30);
		intervals[1] = new Interval(5, 10);
		intervals[2] = new Interval(15, 20);

		System.out.println("Meeting rooms required : \t" + minMeetingRooms(intervals));

	}

	private static int minMeetingRooms(Interval[] intervals) {
		if (intervals == null || intervals.length == 0) {
			return 0;
		}

		// Sort Start Time
		Arrays.parallelSort(intervals, (a, b) -> a.start - b.start);

		// Sort Heap based on end time
		PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);
		minHeap.add(intervals[0]);

		for (Interval interval : intervals) {
			if (!minHeap.isEmpty() && minHeap.peek().end <= interval.start) {
				minHeap.poll();
			}
			minHeap.offer(interval);
		}

		return minHeap.size();
	}

	static class Interval {
		int start;
		int end;

		public Interval() {
			this.start = 0;
			this.end = 0;
		}

		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}

}
