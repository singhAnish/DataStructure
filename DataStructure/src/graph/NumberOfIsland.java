package graph;

public class NumberOfIsland {
	
	public static void main(String[] args) {
		int[][] input = {};
	}

	
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i< grid.length; i++){
            for (int j = 0; j< grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    
    private void dfs(char[][] grid, int row, int col){
        if(row <0 || row >grid.length - 1 || col < 0 ||col >grid[0].length - 1 || grid[row][col] == '0' || grid[row][col] == '#'){
            return;
        }
        
        grid[row][col] = '#';
        dfs(grid, row + 1, col); //Down
        dfs(grid, row - 1, col); //Up
        dfs(grid, row, col + 1); //Right
        dfs(grid, row, col - 1); //Left
    }
}
