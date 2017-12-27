package leetcode;

import java.util.Arrays;

public class Leetcode661 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] M1 = {{1,1,1},
		             {1,0,1},
		             {1,1,1}};
		
		int[][] M2 = 	{{2,3,4},
						{5,6,7},
						{8,9,10},
						{11,12,13},
						{14,15,16}};
		
		
		
		int[][] result = imageSmoother(M2);
		System.out.println(Arrays.toString(imageSmoother(M2)));
		System.out.println();
	}
	
public static int[][] imageSmoother(int[][] M) {
        
		int[][] result = new int[M.length][M[0].length];
        for(int i=0;i<M.length;i++){
            for(int j=0;j<M[0].length;j++){
            	doImageSmooth(M,i,j,result);
            }
        }
        
        
        return result;
    }
    
    public static void doImageSmooth(int[][] M,int i,int j,int[][] result){
        //8 points + (i,j)
        int validSurroundingCells=0;
        int valueOfValidSurroundingCells=0;
        
        if(isValidSurroundingCell(i-1,j-1,M)){
            valueOfValidSurroundingCells+=M[i-1][j-1];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i-1,j,M)){
            valueOfValidSurroundingCells+=M[i-1][j];
            validSurroundingCells++;
        }
        
        
        if(isValidSurroundingCell(i-1,j+1,M)){
            valueOfValidSurroundingCells+=M[i-1][j+1];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i,j-1,M)){
            valueOfValidSurroundingCells+=M[i][j-1];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i,j,M)){
            valueOfValidSurroundingCells+=M[i][j];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i,j+1,M)){
            valueOfValidSurroundingCells+=M[i][j+1];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i+1,j-1,M)){
            valueOfValidSurroundingCells+=M[i+1][j-1];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i+1,j,M)){
            valueOfValidSurroundingCells+=M[i+1][j];
            validSurroundingCells++;
        }
        
        if(isValidSurroundingCell(i+1,j+1,M)){
            valueOfValidSurroundingCells+=M[i+1][j+1];
            validSurroundingCells++;
        }
        
        
        result[i][j] = valueOfValidSurroundingCells/validSurroundingCells;
    }
    
    public static boolean isValidSurroundingCell(int i,int j,int[][] M){
        //0 - Not valid
        //1 - Valid
        if(i < 0 || i >= M.length || j < 0 || j >= M[0].length){
            return false;
        }
        
        return true;
    }

}
