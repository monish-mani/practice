package leetcode;

import java.util.Arrays;

public class Leetcode905 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Leetcode905 lc905 = new Leetcode905();
		int[] arr = {1,2,3,4,5,6};
		
		System.out.println(Arrays.toString(lc905.sortArrayByParity(arr)));
	}
	
	public int[] sortArrayByParity(int[] A) {
        int firstOdd = 0;
        int firstEven = A.length-1;
		
        while(firstOdd < firstEven) {
        	if(A[firstOdd] % 2 == 0) {
        		firstOdd++;
        		continue;
        	}
        	
        	if(A[firstEven] % 2 == 1) {
        		firstEven--;
        		continue;
        	}
        	
        	int temp = A[firstOdd];
        	A[firstOdd] = A[firstEven];
        	A[firstEven] = temp;
        	
        	firstOdd++;
        	firstEven--;
        }
		
		return A;
    }

}
