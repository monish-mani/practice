package leetcode;

import java.util.Arrays;

public class Leetcode490 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[][] maze = {{0,0,0,0,1,0,0},
//						{0,0,1,0,0,0,0},
//						{0,0,0,0,0,0,0},
//						{0,0,0,0,0,0,1},
//						{0,1,0,0,0,0,0},
//						{0,0,0,1,0,0,0},
//						{0,0,0,0,0,0,0},
//						{0,0,1,0,0,0,1},
//						{0,0,0,0,1,0,0}};
		
		int[][] maze = {{0,0,1,0,0},
						{0,0,0,0,0},
						{0,0,0,1,0},
						{1,1,0,1,1},
						{0,0,0,0,0}};
		
		
		
		int[] start = {0,4};
		int[] destination = {3,2};
		
		Leetcode490 lc490 = new Leetcode490();
		System.out.println(lc490.hasPath(maze, start, destination));
		
	}
	
	public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze == null || maze.length == 0 || start == null || start.length == 0 || destination == null || destination.length == 0){
            return false;
        }
        
        return hasPathRecursive(maze,start[0],start[1],destination[0],destination[1]);
    }
    
    private boolean hasPathRecursive(int[][] maze, int srcX, int srcY, int destX,int destY){
    	//System.out.println("Going to position:" + srcX + " " + srcY);
        if(srcX < 0 || srcX == maze.length || srcY < 0 || srcY == maze[0].length || maze[srcX][srcY] == 1 || maze[srcX][srcY] < 0){
            return false;
        }
        
        if(srcX == destX && srcY == destY){
            return true;
        }
        
        maze[srcX][srcY] = -1;
        
        return hasPathRecursive(maze,srcX-1,srcY,destX,destY) ||
                hasPathRecursive(maze,srcX,srcY+1,destX,destY) ||
                hasPathRecursive(maze,srcX+1,srcY,destX,destY) ||
                hasPathRecursive(maze,srcX,srcY-1,destX,destY);
    }

}
