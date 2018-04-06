package leetcode;

import java.util.*;

public class Leetcode54 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { { 1, 2, 3}, { 4, 5, 6}, { 7, 8, 9} };

		int[][] matrix1 = { { 3 }, { 2 } };
		
		int[][] matrix2 = { { 6,9,7 } };

		System.out.println(spiralOrder(matrix));
	}

	public static List<Integer> spiralOrder(int[][] matrix) {

		List<Integer> result = new ArrayList<>();

		if (matrix == null || matrix.length == 0)
			return result;

		int rowTopBoundary = 0;
		int rowBottomBoundary = matrix.length - 1;
		int colLeftBoundary = 0;
		int colRightBoundary = matrix[0].length - 1;

		while (rowTopBoundary <= rowBottomBoundary && colLeftBoundary <= colRightBoundary) {
			// Left - Right
			for (int i = colLeftBoundary; i <= colRightBoundary; i++) {
				result.add(matrix[rowTopBoundary][i]);
			}
			rowTopBoundary++;

			// Top - Bottom
			for (int i = rowTopBoundary; i <= rowBottomBoundary; i++) {
				result.add(matrix[i][colRightBoundary]);
			}
			colRightBoundary--;

			if(rowTopBoundary <= rowBottomBoundary){
				// Right - Left
				for (int i = colRightBoundary; i >= colLeftBoundary; i--) {
					result.add(matrix[rowBottomBoundary][i]);
				}
				rowBottomBoundary--;
			}
			
			if(colLeftBoundary <= colRightBoundary){
				// Bottom - Top
				for (int i = rowBottomBoundary; i >= rowTopBoundary; i--) {
					result.add(matrix[i][colLeftBoundary]);
				}
				colLeftBoundary++;
			}
			
		}

		return result;

	}

}
