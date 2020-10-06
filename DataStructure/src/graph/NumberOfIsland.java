package graph;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water 
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are 
 * all surrounded by water.
 * */
public class NumberOfIsland {

	public static void main(String[] args) {
		char[][] input = { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' }, { '1', '1', '0', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

		System.out.println("Number of Island : \t" + numIslands(input));
	}

	private static int numIslands(char[][] grid) {
		int IslandCount = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					dfs(grid, i, j);
					IslandCount++;
				}
			}
		}
		return IslandCount;
	}

	private static void dfs(char[][] grid, int row, int col) {
		if (row < 0 || row > grid.length - 1 || col < 0 || col > grid[0].length - 1 || grid[row][col] == '0'
				|| grid[row][col] == '#') {
			return;
		}

		grid[row][col] = '#';
		dfs(grid, row + 1, col); // Down
		dfs(grid, row - 1, col); // Up
		dfs(grid, row, col + 1); // Right
		dfs(grid, row, col - 1); // Left
	}
}
