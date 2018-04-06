package leetcode;

public class Leetcode74 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {
		                  {1,   3,  5,  7},
		                  {10, 11, 16, 20},
		                  {23, 30, 34, 50}
						 };
		
		int[][] matrix1 = {{}};
		
		System.out.println(searchMatrix(matrix1,3));
		/*System.out.println(searchMatrix(matrix,16));
		System.out.println(searchMatrix(matrix,50));
		System.out.println(searchMatrix(matrix,77));*/
		

	}

	public static boolean searchMatrix(int[][] matrix, int target) {

		if(matrix.length == 0 || matrix[0].length == 0){
			return false;
		}
		
		int row = -1;
		int a = matrix[0].length - 1;
		
		while (row < matrix.length) {
			if (row >= 0 && target >= matrix[row][0] && target <= matrix[row][matrix[0].length - 1]) {
				break;
			}
			row++;
		}
		
		//Binary search in the row.
		if(row < matrix.length){
			return binarySearch(matrix[row],target);	
		}
		
		return false;
	}
	
	
	public static boolean binarySearch(int[] arr,int target){
		int start = 0;
		int end = arr.length-1;
		
		
		
		while(start <= end){
			int mid = (start + end)/2;
			if(arr[mid] == target){
				return true;
			}else if(arr[mid] < target){
				start = mid + 1;
			}else{
				end = mid - 1;
			}
		}
		
		return false;
	}

}
