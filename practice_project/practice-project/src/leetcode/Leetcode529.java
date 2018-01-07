package leetcode;

public class Leetcode529 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public char[][] updateBoard(char[][] board, int[] click) {
		int clickRow = click[0];
		int clickColumn = click[1];
		doUpdateBoard(board,clickRow,clickColumn,-1);
		
		
		return null;
	}
	
	
	
	public static int doUpdateBoard(char[][] board,int clickRow,int clickColumn, int distanceToNearestMine){
		if(clickRow < 0 || clickRow >= board.length || clickColumn < 0 || clickColumn >= board[0].length){
			return 0;
		}
		
		
		if(board[clickRow][clickColumn] == 'M'){
			return distanceToNearestMine+1;
		}
		
		return 0;
	}
	
	
	

}
