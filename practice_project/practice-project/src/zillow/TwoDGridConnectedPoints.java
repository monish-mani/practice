package zillow;

public class TwoDGridConnectedPoints {
	
	/*
	 * Giving a 2D grid with pixels valued 0 or 1. How to check if pixels A and B are connected through a path of 0-valued pixels. 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid2 = {{1,1,0,0,0},
						 {1,1,0,0,0},
						 {0,0,0,1,1},
						 {0,0,0,0,0}};
	
		
		int[][] grid1 = {{0,1,0},
						{0,0,1}};
		
		
		
		System.out.println(isConnected(0,4,3,4,grid2));
	}
	
	
	public static boolean isConnected(int currentRow, int currentColumn, int targetRow, int targetColumn, int[][] grid){
		if(currentRow < 0 || currentRow >= grid.length || currentColumn < 0 || currentColumn >= grid[0].length || grid[currentRow][currentColumn]!=0){
			return false;
		}
		
		if(currentRow == targetRow && currentColumn == targetColumn){
			return true;
		}
		
		int originalValue = grid[currentRow][currentColumn];
		
		grid[currentRow][currentColumn]=  -1;
		
		boolean result =  isConnected(currentRow,currentColumn-1,targetRow,targetColumn,grid) ||
				isConnected(currentRow-1,currentColumn,targetRow,targetColumn,grid) ||
				isConnected(currentRow,currentColumn+1,targetRow,targetColumn,grid) ||
				isConnected(currentRow+1,currentColumn,targetRow,targetColumn,grid);
	
		grid[currentRow][currentColumn] = originalValue;
		
		return result;
	}

}
