package leetcode;
import java.util.*;

public class Leetcode723 {
	
	class Position{
		//Starting point
		int row;
		int col;
		
		public Position(int row,int col){
			this.row = row;
			this.col = col;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] candyCrush(int[][] board) {
		if(board == null || board.length == 0) return board;
		
		Set<Position> similarCandy = new HashSet<>();
		
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				findNearbySimilarCandy(board,i,j,board[i][j],similarCandy);
			}
		}
		
		
		
		return null;

	}
	
	
	private int findNearbySimilarCandy(int[][] board,int row,int col,int candyId,int direction,int length){
		if(row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] < 0 || candyId!=board[row][col]) return length;
		
		int upLength = findNearbySimilarCandy(board,row-1,col,candyId,0,length+1);
		int rightLength = findNearbySimilarCandy(board,row,col+1,candyId,1,length+1);
		int downLength = findNearbySimilarCandy(board,row+1,col,candyId,2,length+1);
		int leftLength = findNearbySimilarCandy(board,row,col-1,candyId,3,length+1);
		
		if(upLength >= 3){
			for(int i=0;i<upLength;i++){
				
			}
		}
		
	}
	
	private void findSimilarCandyFromPosition()
	
	

}
