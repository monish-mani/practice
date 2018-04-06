package leetcode;

import java.util.Arrays;

public class Leetcode289 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] board = {{1,1},{1,0}};
		
		gameOfLife(board);
		
		for(int i=0;i<board.length;i++){
			System.out.println(Arrays.toString(board[i]));
		}
	}
	
	
	public static void gameOfLife(int[][] board){
		int[][] newBoard = new int[board.length][board[0].length];
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				computeNextState(board,i,j);
			}
		}
		
		for (int k = 0; k < board.length; k++) {
            for (int l = 0; l < board[0].length; l++) {
                board[k][l] >>= 1;  // Get the 2nd state.
            }
        }
        
		
	}
	
	
	public static void computeNextState(int[][] board,int i,int j){
		int liveNeighbors = computeLiveNeighbors(board,i,j);
		
		if (board[i][j] == 1 && liveNeighbors >= 2 && liveNeighbors <= 3) {  
            board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
        }
        if (board[i][j] == 0 && liveNeighbors == 3) {
            board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
        }
        
        int a = board.length;
        int b = board[0].length;
        
        
        
        System.out.println();
	}
	
	
	public static int computeLiveNeighbors(int[][] board,int i,int j){
		
		return isLiveNeighbor(board,i-1,j-1) +
				isLiveNeighbor(board,i-1,j) +
				isLiveNeighbor(board,i-1,j+1) +
				isLiveNeighbor(board,i,j+1) +
				isLiveNeighbor(board,i+1,j+1) +
				isLiveNeighbor(board,i+1,j) +
				isLiveNeighbor(board,i+1,j-1) +
				isLiveNeighbor(board,i,j-1);
	}
	
	
	public static int isLiveNeighbor(int[][] board,int i,int j){
		if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j]==0){
			return 0;
		}
		
		return board[i][j] & 1;
	}

}
