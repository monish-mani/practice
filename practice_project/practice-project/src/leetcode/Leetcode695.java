package leetcode;

public class Leetcode695 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] grid = {{1,1,0,0,0},
						{1,1,0,0,0},
						{0,0,0,1,1},
						{0,0,0,1,1}};
		
		System.out.println(maxAreaOfIsland(grid));
	}
	
	public static int maxAreaOfIsland(int[][] grid) {
        int maxArea=0;
        int currentArea=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                currentArea = traverse(i,j,grid);
                if(currentArea > maxArea){
                    maxArea = currentArea;
                }
            }
        }
       
        return maxArea;
    }
    
    
    public static int traverse(int i,int j,int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] <= 0){
            return 0;
        }
        
        //To include the size of the current position
        int size =1;
        grid[i][j]=-1;
        size += traverse(i-1,j,grid) + traverse(i,j+1,grid) + traverse(i+1,j,grid) + traverse(i,j-1,grid);
        
        return size;
    }

}
