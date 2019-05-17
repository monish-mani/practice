package leetcode;

import java.util.Arrays;

public class Leetcode64 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode64 lc64 = new Leetcode64();
		int[][] grid = {{1,3,1},
						{1,5,1},
						{4,2,1}};
		
		System.out.println(lc64.minPathSum(grid));
	}
	
	public int minPathSum(int[][] grid) {
        if(grid == null || grid.length ==0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] minCostGrid = new int[m][n];
        
        //Populate first col
        int sum=0;
        for(int i=0;i<grid.length;i++){
            minCostGrid[i][0] =grid[i][0] + sum;
            sum = minCostGrid[i][0];
        }
        
        sum=0;
        //Populate first row
        for(int j=0;j<grid[0].length;j++){
             minCostGrid[0][j] =grid[0][j] + sum;
            sum=minCostGrid[0][j];
        }
        
        System.out.println(Arrays.deepToString(minCostGrid));
        
        for(int i=1;i<minCostGrid.length;i++){
            for(int j=1;j<minCostGrid[0].length;j++){
                minCostGrid[i][j] = Math.min(grid[i][j]+minCostGrid[i][j-1],grid[i][j]+minCostGrid[i-1][j]);
            }
        }
        
        return minCostGrid[m-1][n-1];
    }

}
