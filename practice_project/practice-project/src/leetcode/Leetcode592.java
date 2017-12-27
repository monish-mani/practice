package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode592 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression1 = "-1/2+1/2";
		String expression2= "5/3+1/3";
		String expression3="-1/3-1/2";
		fractionAddition(expression1);

	}

	public static String fractionAddition(String expression) {

		int finalNumerator=0;
		int finalDenominator=1;
		int numeratorSign=1;

		// Scan the string
		int i=0;
		while (i < expression.length()) {
			int numerator=0;
			int denominator=1;
			if(expression.charAt(i) == '+' || expression.charAt(i)=='-'){
				numerator = expression.charAt(i) == '+' ? 1 : -1;
				i++;
			}
			
			/*
			 * Ascii 0 - 49 , 9 - 57
			 */
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
				numerator*=expression.charAt(i) - '0';
				i++;
			}
			
			if(expression.charAt(i) == '/'){
				i++;
			}
			
			if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
				denominator*=expression.charAt(i) - '0';
				i++;
				//Calculating common divisor while adding denominator to the final denominator
				if(finalDenominator%denominator == 0){
					//current denominator is a factor of final denominator --> need to multiply numerator with corresponding mutiplication factor
					numerator*=finalDenominator/denominator;
				}else{
					numerator*=finalDenominator;
					finalDenominator*=denominator;
					finalNumerator*=denominator;
					
				}
				if(numerator < 1 && numerator > finalNumerator){
					
				}
				finalNumerator+=numerator;
				numerator=0;
				denominator=1;
			}
			
		}
		
		System.out.println(finalNumerator+"/"+finalDenominator);
		
		
		
		return finalNumerator+"/"+finalDenominator;
	}

}
