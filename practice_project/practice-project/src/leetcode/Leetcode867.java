package leetcode;

import java.util.Arrays;

public class Leetcode867 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode867 lc867 = new Leetcode867();
		
		int[][] A = {{1,2,3},
						{4,5,6},
						{7,8,9}};
		
		int[][] A1 = {{1,2,3},
						{4,5,6}};
		
		
		System.out.println(Arrays.deepToString(lc867.transpose(A1)));
		
	}
	
	public int[][] transpose(int[][] A) {
        
        int[][] aTranspose = new int[A[0].length][A.length];
        
        for(int i=0;i<A.length;i++) {
        	for(int j=0;j<A[0].length;j++) {
        		aTranspose[j][i] = A[i][j];
        	}
        }
	
        
		return aTranspose;
		
    }
	
	private void swap(int[][] A,int row, int i, int col) {
		int temp = A[i][row];
		A[i][row] = A[col][i];
		A[col][i] = temp;
		
	}

}
