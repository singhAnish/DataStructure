package facebook;

import java.util.Arrays;

public class TaskScheduler {
	
	public static void main(String[] args) {
		char[] tasks = {'A', 'B', 'A', 'A', 'B', 'B'};
		int n = 2;
		int leastInterval = leastInterval(tasks, n);
		System.out.println("Least Interval : \t" + leastInterval );
	}
	
	private static int leastInterval (char[] tasks, int n) {
		
		int[] freq = new int[26];
		for(char c  : tasks) {
			freq[c - 'A']++ ;
		}
		
		Arrays.sort(freq);
		
		int maxChunk = freq[25] -1;
		int idleSpots = maxChunk  * n;
		
		for (int i = 24; i >= 0; i--) {
			idleSpots = idleSpots - Math.min(maxChunk, freq[i] );
		}
		
		return idleSpots > 0 ? idleSpots + tasks.length : tasks.length;
	}

}
