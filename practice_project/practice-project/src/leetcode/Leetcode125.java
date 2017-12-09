package leetcode;

public class Leetcode125 {
	
	public static void main(String[] args){
		
		
	}
	
	public boolean isPalindrome(String s) {
		//a-z = 97 - 122
		//A-Z = 65-90
		//0-9 = 48-57
		
		int start = 0;
		int end = s.length()-1;
		
		while(start <= end){
			
		}
		
		
		return false;
	}
	
	
	//Function to check if both the characters are either alphabets or numbers
	public boolean isSameAlphaNumericChar(String s,int start,int end){
		if(start == end)
			return true;
		
		char a = s.charAt(start);
		char b = s.charAt(end);
		
		boolean aAlphabet = false;
		boolean bAlphabet = false;
		
		if(a >= '0' && a <='9'){
			
		}
		
		return false;
	}

}
