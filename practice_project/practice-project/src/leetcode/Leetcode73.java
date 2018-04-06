package leetcode;

import java.util.*;

public class Leetcode73 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void setZeroes(int[][] matrix) {
        List<Integer> rowsContainingZero = new ArrayList<>();
        List<Integer> columnsContainingZero = new ArrayList<>();
		
        
        
        for(int i=0;i<matrix.length;i++){
        	for(int j=0;j<matrix[0].length;j++){
        		if(matrix[i][j] == 0){
        			rowsContainingZero.add(i);
        			columnsContainingZero.add(j);
        		}
        	}
        }
        
        //Setting entire rows and columns as zeros.
        
        //Row
        for(Integer row : rowsContainingZero){
        	for(int j=0;j<matrix[0].length;j++){
            	matrix[row][j] = 0;
            }
        }
        
        //Column
        for(Integer column : columnsContainingZero){
        	for(int i=0;i<matrix.length;i++){
        		matrix[i][column]=0;
        	}
        }
        
    }

}
