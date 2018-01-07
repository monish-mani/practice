package leetcode;

public class Leetcode200 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char grid[][] = {
						{'1','0','1','1','1'},
						{'1','0','1','0','1'},
						{'1','1','1','0','1'}
						};
		
		System.out.println(numIslands(grid));
		
		System.out.println(Integer.MAX_VALUE);
		
		
		
	}
	
	public static int numIslands(char[][] grid) {
        int islandCount=0;
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(traverse(i,j,grid) > 0){
                    islandCount++;
                }
            }
        }
        
        return islandCount;
    }
    
    
    public static int traverse(int i,int j,char[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j>=grid[0].length || grid[i][j] == '0' || grid[i][j]=='2'){
            return 0;
        }
        
        grid[i][j]='2';
        
        return traverse(i,j+1,grid) + traverse(i+1,j,grid) + traverse(i,j-1,grid) + traverse(i-1,j,grid) + 1;
    }
	
	

}
