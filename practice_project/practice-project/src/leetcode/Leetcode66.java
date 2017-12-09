package leetcode;

import java.util.Arrays;

public class Leetcode66 {
	
	public static void main(String args[]){
		int[] digits = {9,9,9,9,8};
		System.out.println(Arrays.toString(plusOne(digits)));;
		
	}
	
	
	public static int[] plusOne(int[] digits) {
        //123 = {1,2,3};
        //999 = {9,9,9};
		
		boolean newArrayFlag = true;
		for(int i=0;i<digits.length;i++){
			if(digits[i]!=9){
				newArrayFlag = false;
			}
		}
        System.out.println(newArrayFlag);
		int[] result = digits;
		
		if(newArrayFlag){
			result = new int[digits.length+1];
		}
		int carry=0;
		int targetNumber = 1; //Target number to be added. In this case its 1.
		
		for(int i=digits.length-1;i>=0;i--){
			int sum = digits[i]+carry+targetNumber;
			carry = sum/10 > 0 ? 1 : 0;
			result[i] = sum%10;
			targetNumber=0;
		}
		
		if(carry > 0){
			result[0] = carry;
		}
		
		return result;
    }

}
