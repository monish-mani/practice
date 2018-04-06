package leetcode;

public class Leetcode562 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int longestLine(int[][] M) {
		
		int longestLine = Integer.MIN_VALUE;
		
		for(int i=0;i<M.length;i++){
			for(int j=0;j<M[0].length;j++){
				int currentLine = getLongestLineFromPosition(M,i,j);
				if(currentLine > longestLine){
					longestLine = currentLine;
				}
			}
		}

		return 0;
	}
	
	
	public static int getLongestLineFromPosition(int[][] M,int i,int j){
		int vertical = getLongestLineFromPositionWithDirection(M,i,j,1,0);
		int horizontal = getLongestLineFromPositionWithDirection(M,i,j,2,0);
		int rightDiagonal = getLongestLineFromPositionWithDirection(M,i,j,3,0);
		int leftDiagonal = getLongestLineFromPositionWithDirection(M,i,j,4,0);
		
		
		return Math.max(Math.max(Math.max(vertical, horizontal), rightDiagonal), leftDiagonal);
		
	}
	
	
	public static int getLongestLineFromPositionWithDirection(int[][] M,int i,int j, int direction, int lengthSoFar){
		if(i < 0 || i > M.length || j < 0 || j > M[0].length || M[i][j] == 0){
			return lengthSoFar;
		}
		
		lengthSoFar++;
		
		if(direction == 1){
			//lengthFromPosition = getLongestLineFromPositionWithDirection(M,i-1,j,1,lengthSoFar) + getLongestLineFromPositionWithDirection(M,i+1,j,1,lengthSoFar);
		}
		return 0;
	}

}
