package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode680 {
	
	public static void main(String args[]){
		System.out.println(validPalindrome("abca"));
		
	}
	
	
	//abcdcbxa
	
	
	public static boolean validPalindrome(String s){
		int start = 0;
		int end = s.length()-1;
		
		while(start < end && s.charAt(start) == s.charAt(end)){
			start++;
			end--;
		}
		
		if(start > end){
			return true;
		}
		
		return isValidPalindrome(s,start+1,end) || isValidPalindrome(s,start,end-1);
	}
	
	public static boolean isValidPalindrome(String s,int start,int end){
		while(start < end && s.charAt(start) == s.charAt(end)){
			start++;
			end--;
		}
		
		if(start >= end){
			return true;
		}
		
		return false;
	}

}
