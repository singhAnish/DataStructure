package graph;

import java.util.LinkedList;
import java.util.Queue;

public class WallsAndGates {

	public static void main(String[] args) {

		int max = Integer.MAX_VALUE;
		int[][] input = { { max, -1, 0, max }, { max, max, max, -1 }, { max, -1, max, -1 }, { 0, -1, max, max } };

		wallsGates(input);

		for (int i = 0; i < input.length; i++) {
			for (int j = 0; j < input[0].length; j++) {
				System.out.print(input[i][j] + "\t");
			}	
			System.out.println();
		}
	}

	private static void wallsGates(int[][] rooms) {

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < rooms.length; i++) {
			for (int j = 0; j < rooms[0].length; j++) {
				if (rooms[i][j] == 0)
					q.offer(new int[] { i, j });
			}
		}

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				int[] curr = q.poll();
				int currX = curr[0];
				int currY = curr[1];
				for (int[] dir : dirs) {
					int x = currX + dir[0];
					int y = currY + dir[1];
					if (x < 0 || x > rooms.length - 1 || y < 0 || y > rooms[0].length - 1 
							|| rooms[x][y] == -1) // Adding rooms[x][y]==-1 is optional
						continue;
					if (rooms[x][y] == Integer.MAX_VALUE) {
						rooms[x][y] = rooms[currX][currY] + 1;
						q.offer(new int[] { x, y });
					}
				}
			}
		}

	}

}
